package sc.senai.topcare.service.funcionario;

import sc.senai.topcare.controller.dto.funcionario.FuncionarioPostDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioRequestPutDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioSimplesResponseDto;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.exceptions.ListaVaziaException;

import java.util.List;

public interface FuncionarioService {
    Boolean cadastro(FuncionarioPostDto dto);
    FuncionarioRequestPutDto editarFuncionario(Long id, FuncionarioRequestPutDto dto);
    FuncionarioResponseDTO buscarFuncionario(Long id);
    List<FuncionarioSimplesResponseDto> buscarTodosSimples() throws ListaVaziaException;
    Boolean excluir(Long id);
    List<FuncionarioResponseDTO> buscarTodos() throws ListaVaziaException;
    Funcionario buscarFuncionarioPorId(Long id);
}
