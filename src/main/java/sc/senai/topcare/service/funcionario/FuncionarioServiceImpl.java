package sc.senai.topcare.service.funcionario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.FuncionarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository repository;

    @Override
    public List<FuncionarioResponseDTO> buscarTodos() throws ListaVaziaException {
        List<FuncionarioResponseDTO> funcionarios = repository.findAll().stream().map(FuncionarioResponseDTO::new).toList();
        if(funcionarios.isEmpty()){
            throw new ListaVaziaException();
        }
        return funcionarios;
    }
}
