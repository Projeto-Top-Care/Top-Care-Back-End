package sc.senai.topcare.service.funcionario;

import sc.senai.topcare.controller.dto.funcionario.FuncionarioPostDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioSimplesResponseDto;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.exceptions.ListaVaziaException;

import java.util.List;

public interface FuncionarioService {
    Boolean cadastro(FuncionarioPostDto dto);
    Funcionario editarFuncionario(Long id, FuncionarioPostDto dto);
    FuncionarioResponseDTO buscarFuncionario(Long id);
    List<FuncionarioSimplesResponseDto> buscarTodos() throws ListaVaziaException;
    Boolean excluir(Long id);
}