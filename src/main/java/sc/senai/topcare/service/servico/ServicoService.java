package sc.senai.topcare.service.servico;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;
import sc.senai.topcare.controller.dto.servicos.ServicoResponseDTO;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.exceptions.ListaVaziaException;

import java.util.List;

@Service
public interface ServicoService {
    void cadastrar(ServicoRequestDTO dto);
    List<ServicoResponseDTO> buscarTodos() throws ListaVaziaException;
    ServicoResponseDTO buscarPorId(Long id);
    Boolean editar(ServicoRequestDTO dto, Long id);
    Boolean deletar(Long id);
}
