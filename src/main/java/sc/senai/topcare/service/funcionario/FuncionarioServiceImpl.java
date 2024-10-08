package sc.senai.topcare.service.funcionario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.agendamento.AgendamentoResponseDTO;
import sc.senai.topcare.controller.dto.agendamento.HorarioResponseDTO;
import sc.senai.topcare.controller.dto.agendamento.PagamentoResponseDTO;
import sc.senai.topcare.controller.dto.conjuntas.IdNomeResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioPostDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioRequestPutDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioSimplesResponseDto;
import sc.senai.topcare.controller.dto.horarios.HorariosReservadosDto;
import sc.senai.topcare.controller.dto.usuario.response.pet.PetResponseDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.entity.Filial;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.entity.Horario;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.AgendamentoRepository;
import sc.senai.topcare.repository.FilialRepository;
import sc.senai.topcare.repository.FuncionarioRepository;
import sc.senai.topcare.repository.HorarioRepository;
import sc.senai.topcare.service.agendamento.AgendamentoServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private FilialRepository filialRepository;
    private FuncionarioRepository repository;
    private AgendamentoRepository agendamentoRepository;

    @Override
    public Boolean cadastro(FuncionarioPostDto dto) {
        Filial filial = filialRepository.findByNome(dto.getNomeFilial());
        Funcionario funcionario = new Funcionario(
                dto.getNome(),
                dto.getCodigo(),
                dto.getRole(),
                dto.getEmail(),
                dto.getCelular(),
                dto.getCpf(),
                dto.getDataNascimento(),
                dto.getSexo(),
                dto.getSenha(),
                filial
        );
        repository.save(funcionario);
        return true;
    }

    @Override
    public FuncionarioRequestPutDto editarFuncionario(Long id, FuncionarioRequestPutDto dto) {
        Funcionario funcionario = repository.findById(id).get();
        Filial filial = funcionario.getFilial();
        funcionario.setSexo(dto.getSexo());
        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setCelular(dto.getCelular());
        funcionario.setDataNascimento(dto.getDataNascimento());
        funcionario.setFilial(filial);

        funcionario.setId(id);
        repository.save(funcionario);
        return new FuncionarioRequestPutDto(
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getCelular(),
                funcionario.getDataNascimento(),
                funcionario.getSexo(),
                filial.getNome()
        );
    }

    @Override
    public FuncionarioResponseDTO buscarFuncionario(Long id) {
        Funcionario funcionario = repository.findById(id).get();
        String nomeFilial = funcionario.getFilial().getNome();
        Agendamento agendamento = new Agendamento();
        Horario horario = new Horario(
                null,
                funcionario,
                agendamento,
                true,
                LocalDate.now(),
                LocalTime.now(),
                LocalTime.now().plusMinutes(30));

        return new FuncionarioResponseDTO(
                funcionario.getNome(),
                funcionario.getCodigo(),
                funcionario.getEmail(),
                funcionario.getCelular(),
                funcionario.getCpf(),
                funcionario.getDataNascimento(),
                funcionario.getSexo(),
                nomeFilial,
                List.of(horario, horario)
        );
    }

    @Override
    public List<FuncionarioSimplesResponseDto> buscarTodosSimples() throws ListaVaziaException {
        List<FuncionarioSimplesResponseDto> funcionarios = repository.findAll().stream().map(FuncionarioSimplesResponseDto::new).toList();
        if(funcionarios.isEmpty()){
            throw new ListaVaziaException();
        }
        return funcionarios;
    }

    @Override
    public Boolean excluir(Long id) {
        Funcionario funcionario = buscarFuncionarioPorId(id);

        for(Servico s : funcionario.getServicos()){
            s.getFuncionarios().remove(funcionario);
        }
        for(Horario horario : funcionario.getHorariosAgendados()){
            horario.setFuncionario(null);
        }
        funcionario.getServicos().clear();
        funcionario.getHorariosAgendados().clear();
        repository.save(funcionario);
        repository.delete(funcionario);
        return true;
    }

    @Override
    public List<IdNomeResponseDTO> buscarTodos() throws ListaVaziaException {
        List<IdNomeResponseDTO> funcionarios = repository.findAll().stream().map(IdNomeResponseDTO::new).toList();
        if(funcionarios.isEmpty()){
            throw new ListaVaziaException();
        }
        return funcionarios;
    }

    @Override
    public Funcionario buscarFuncionarioPorId(Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        if(funcionario.isEmpty()){
            throw new NoSuchElementException("O funcionario não existe");
        }
        return funcionario.get();
    }

    @Override
    public List<HorariosReservadosDto> buscarHorariosReservados(Long id) {
//        Funcionario funcionario = funcionarioRepository.findById(id).get();
//        List<Horario>horarios =  funcionario.getHorariosAgendados().stream().filter();
////        List<Horario>
        return null;
    }

    @Override
    public List<AgendamentoResponseDTO> verAgendamentos(Long id) {
        List<Agendamento> agendamentosTodos = agendamentoRepository.findAllByHorario_Funcionario_Id(id);
        List<AgendamentoResponseDTO> agendamentos = new ArrayList<>();
        for(Agendamento agendamento : agendamentosTodos){
            agendamentos.add(new AgendamentoResponseDTO(
                    agendamento.getId(),
                    agendamento.getLocal().getNome(),
                    new HorarioResponseDTO(
                            agendamento.getHorario().getId(),
                            agendamento.getHorario().getDia(),
                            agendamento.getHorario().getHoraInicio(),
                            agendamento.getHorario().getFuncionario().getNome()),
                    agendamento.getServico(),
                    new PetResponseDTO(agendamento.getPet()),
                    agendamento.getStatus().getNOME(),
                    agendamento.getCliente().getNome(),
                    new PagamentoResponseDTO(agendamento.getPagamento()),
                    agendamento.getStatus().getNOME()));
        }
        return agendamentos;
    }
}
