package sc.senai.topcare.service.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;
import sc.senai.topcare.controller.dto.servicos.ServicoResponseDTO;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicoServiceImpl implements ServicoService {

    private final ServicoRepository repository;

    @Override
    public void cadastrar(ServicoRequestDTO dto) {
        Servico servico = new Servico(dto);
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
        return null;
    }
}
