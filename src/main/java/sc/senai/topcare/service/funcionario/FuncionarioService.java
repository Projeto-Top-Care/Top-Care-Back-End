package sc.senai.topcare.service.funcionario;

import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.exceptions.ListaVaziaException;

import java.util.List;

public interface FuncionarioService {
    List<FuncionarioResponseDTO> buscarTodos() throws ListaVaziaException;
    Funcionario buscarFuncionario(Long id);
}
