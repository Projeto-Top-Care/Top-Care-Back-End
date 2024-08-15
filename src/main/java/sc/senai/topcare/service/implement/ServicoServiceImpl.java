package sc.senai.topcare.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.repository.ServicoRepository;
import sc.senai.topcare.service.interfaces.ServicoService;
import sc.senai.topcare.utils.ModelMapperUtil;

@Service
@RequiredArgsConstructor
public class ServicoServiceImpl implements ServicoService {

    private final ServicoRepository repository;

    @Override
    public void cadastrar(ServicoRequestDTO dto) {
        Servico servico = new Servico(dto);
        repository.save(servico);
    }
}
