package sc.senai.topcare.service.especie;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.conjuntas.IdNomeResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.exceptions.ListaVaziaException;

import java.util.List;

@Service
public interface EspecieService {
    List<IdNomeResponseDTO> buscarTodos() throws ListaVaziaException;
}
