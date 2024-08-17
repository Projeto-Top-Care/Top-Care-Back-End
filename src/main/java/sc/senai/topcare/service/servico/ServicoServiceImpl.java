package sc.senai.topcare.service.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.repository.ServicoRepository;

import java.util.List;

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
    public List<Servico> buscarTodos() {
        return null;
    }

    @Override
    public Servico buscarPorId(Long id) {
        return null;
    }

    @Override
    public Boolean editar(ServicoRequestDTO dto, Long id) {
        return null;
    }

    @Override
    public Boolean deletar(Long id) {
        return null;
    }
}
