package sc.senai.topcare.service.funcionario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.FuncionarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @Override
    public Funcionario buscarFuncionario(Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        if(funcionario.isEmpty()){
            throw new NoSuchElementException("O funcionario não existe");
        }
        return funcionario.get();
    }
}
