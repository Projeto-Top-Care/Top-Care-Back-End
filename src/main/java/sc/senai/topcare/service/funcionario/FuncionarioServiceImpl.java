package sc.senai.topcare.service.funcionario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioPostDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioSimplesResponseDto;
import sc.senai.topcare.entity.Filial;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.exceptions.UsuarioNaoEncontradoException;
import sc.senai.topcare.repository.FilialRepository;
import sc.senai.topcare.repository.FuncionarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private FuncionarioRepository repository;
    private FilialRepository filialRepository;

    @Override
    public Boolean cadastro(FuncionarioPostDto dto) {
        Filial filial = filialRepository.findById(dto.getIdFilial()).get();
        Funcionario funcionario = new Funcionario(
                dto.getNome(),
                dto.getRole(),
                dto.getEmail(),
                dto.getCelular(),
                dto.getCpf(),
                dto.getDataNascimento(),
                dto.getSexo(),
                dto.getSenha(),
                filial
        );
        funcionarioRepository.save(funcionario);
        return true;
    }

    @Override
    public Funcionario editarFuncionario(Long id, FuncionarioPostDto dto) {
        Filial filial = filialRepository.findById(dto.getIdFilial()).get();
        Funcionario funcionario = new Funcionario(
                dto.getNome(),
                dto.getRole(),
                dto.getEmail(),
                dto.getCelular(),
                dto.getCpf(),
                dto.getDataNascimento(),
                dto.getSexo(),
                dto.getSenha(),
                filial
        );
        funcionario.setId(id);
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    @Override
    public Funcionario buscarFuncionario(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    @Override
    public List<FuncionarioSimplesResponseDto> buscarTodos() throws ListaVaziaException {
        List<FuncionarioSimplesResponseDto> funcionarios = repository.findAll().stream().map(FuncionarioSimplesResponseDto::new).toList();
        if(funcionarios.isEmpty()){
            throw new ListaVaziaException();
        }
        return funcionarios;
    }

    @Override
    public Boolean excluir(Long id) {
        funcionarioRepository.deleteById(id);
        return true;
    }
}
