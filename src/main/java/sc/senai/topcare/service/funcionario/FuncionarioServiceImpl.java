package sc.senai.topcare.service.funcionario;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.conjuntas.IdNomeResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioPostDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioRequestPutDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioSimplesResponseDto;
import sc.senai.topcare.controller.dto.horarios.HorariosReservadosDto;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.enuns.Porte;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.exceptions.UsuarioNaoEncontradoException;
import sc.senai.topcare.repository.FilialRepository;
import sc.senai.topcare.repository.FuncionarioRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private FuncionarioRepository repository;
    private FilialRepository filialRepository;

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
        funcionarioRepository.save(funcionario);
        return true;
    }

    @Override
    public FuncionarioRequestPutDto editarFuncionario(Long id, FuncionarioRequestPutDto dto) {
        Filial filial = filialRepository.findByNome(dto.getNomeFilial());
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        funcionario.setSexo(dto.getSexo());
        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setCelular(dto.getCelular());
        funcionario.setDataNascimento(dto.getDataNascimento());
        funcionario.setFilial(filial);

        funcionario.setId(id);
        funcionarioRepository.save(funcionario);
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
        Funcionario funcionario = funcionarioRepository.findById(id).get();
        String nomeFilial = filialRepository.findById(funcionario.getFilial().getId()).get().getNome();
        Agendamento agendamento = new Agendamento();
        agendamento.setValor(8985.7);
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
        funcionarioRepository.deleteById(id);
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
}
