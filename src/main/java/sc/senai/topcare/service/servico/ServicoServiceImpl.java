package sc.senai.topcare.service.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.controller.dto.horarios.FuncionarioHorarioDTO;
import sc.senai.topcare.controller.dto.horarios.HorarioResponseDTO;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;
import sc.senai.topcare.controller.dto.servicos.ServicoResponseDTO;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.entity.Horario;
import sc.senai.topcare.entity.Imagem;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.ServicoRepository;
import sc.senai.topcare.service.horario.HorarioService;
import sc.senai.topcare.service.imagem.ImagemServiceImp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicoServiceImpl implements ServicoService {

    private final ServicoRepository repository;
    private final HorarioService horarioService;
    private final ImagemServiceImp imagemService;

    @Override
    public void cadastrar(ServicoRequestDTO dto, MultipartFile multipartFile) {
        Servico servico = new Servico(dto);
        Imagem imagem = imagemService.salvarImagem(multipartFile);
        servico.setImagem(imagem);
        repository.save(servico);
    }

    @Override
    public List<ServicoResponseDTO> buscarTodos() throws ListaVaziaException {
        List<ServicoResponseDTO> servicos = repository
                .findAll()
                .stream()
                .map(ServicoResponseDTO::new)
                .toList();
        if(servicos.isEmpty()){
            throw new ListaVaziaException();
        }
        return servicos;
    }

    @Override
    public ServicoResponseDTO buscarPorId(Long id) {
        Optional<Servico> servico = repository.findById(id);
        if(servico.isEmpty()){
            throw new RuntimeException("O Serviço não existe");
        }
        return new ServicoResponseDTO(servico.get());
    }

    @Override
    public Boolean editar(ServicoRequestDTO dto, Long id) {
        Servico servico = repository.findById(id).orElseThrow(RuntimeException::new);
        servico.editar(dto);
        repository.save(servico);
        return true;
    }

    @Override
    public Boolean deletar(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<FuncionarioHorarioDTO> buscarHorariosPorServico(Long id, LocalDate dia) {
        Servico servico = repository.findById(id).orElseThrow(NoSuchElementException::new);
        List<FuncionarioHorarioDTO> funcionarioHorarios = new ArrayList<>();

        servico.getFuncionarios().forEach(funcionario -> {
            List<Horario> horarios = horarioService.buscarPorDiaELivre(dia, funcionario.getId());
            if(!horarios.isEmpty()){
                FuncionarioHorarioDTO funcionarioHorario = new FuncionarioHorarioDTO(
                        funcionario.getId(),
                        funcionario.getNome(),
                        horarios
                );
                funcionarioHorarios.add(funcionarioHorario);
            }
        });

        return funcionarioHorarios;
    }
}
