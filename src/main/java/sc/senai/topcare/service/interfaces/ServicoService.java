package sc.senai.topcare.service.interfaces;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;

@Service
public interface ServicoService {
    void cadastrar(ServicoRequestDTO dto);
}
