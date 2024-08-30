package sc.senai.topcare.service.funcionario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.conjuntas.IdNomeResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioPostDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioRequestPutDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioSimplesResponseDto;
import sc.senai.topcare.entity.Filial;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.entity.Horario;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.exceptions.UsuarioNaoEncontradoException;
import sc.senai.topcare.repository.FilialRepository;
import sc.senai.topcare.repository.FuncionarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository repository;
    private FilialRepository filialRepository;

    @Override
    public Boolean cadastro(FuncionarioPostDto dto) {
        Filial filial = filialRepository.findByNome(dto.getNomeFilial());
        Funcionario funcionario = new Funcionario(
                dto.getNome(),
                dto.getCodigo(),
                dto.getRole(),
                dto.getEmail(),
                dto.getCelular(),
                dto.getCpf(),
                dto.getDataNascimento(),
                dto.getSexo(),
                dto.getSenha(),
                filial
        );
        repository.save(funcionario);
        return true;
    }

    @Override
    public FuncionarioRequestPutDto editarFuncionario(Long id, FuncionarioRequestPutDto dto) {
        Filial filial = filialRepository.findByNome(dto.getNomeFilial());
        Funcionario funcionario = repository.findById(id).get();
        funcionario.setSexo(dto.getSexo());
        funcionario.setNome(dto.getNome());
        funcionario.setEmail(dto.getEmail());
        funcionario.setCelular(dto.getCelular());
        funcionario.setDataNascimento(dto.getDataNascimento());
        funcionario.setFilial(filial);

        funcionario.setId(id);
        repository.save(funcionario);
        return new FuncionarioRequestPutDto(
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getCelular(),
                funcionario.getDataNascimento(),
                funcionario.getSexo(),
                filial.getNome()
        );
    }

    @Override
    public FuncionarioResponseDTO buscarFuncionario(Long id) {
        Funcionario funcionario = repository.findById(id).get();
        String nomeFilial = filialRepository.findById(funcionario.getFilial().getId()).get().getNome();
        return new FuncionarioResponseDTO(
                funcionario.getNome(),
                funcionario.getCodigo(),
                funcionario.getEmail(),
                funcionario.getCelular(),
                funcionario.getCpf(),
                funcionario.getDataNascimento(),
                funcionario.getSexo(),
                nomeFilial
        );
    }

    @Override
    public List<FuncionarioSimplesResponseDto> buscarTodosSimples() throws ListaVaziaException {
        List<FuncionarioSimplesResponseDto> funcionarios = repository.findAll().stream().map(FuncionarioSimplesResponseDto::new).toList();
        if(funcionarios.isEmpty()){
            throw new ListaVaziaException();
        }
        return funcionarios;
    }

    @Override
    public Boolean excluir(Long id) {
        Funcionario funcionario = buscarFuncionarioPorId(id);

        for(Servico s : funcionario.getServicos()){
            s.getFuncionarios().remove(funcionario);
        }
        for(Horario horario : funcionario.getHorariosAgendados()){
            horario.setFuncionario(null);
        }
        funcionario.getServicos().clear();
        funcionario.getHorariosAgendados().clear();
        repository.save(funcionario);
        repository.delete(funcionario);
        return true;
    }

    @Override
    public List<IdNomeResponseDTO> buscarTodos() throws ListaVaziaException {
        List<IdNomeResponseDTO> funcionarios = repository.findAll().stream().map(IdNomeResponseDTO::new).toList();
        if(funcionarios.isEmpty()){
            throw new ListaVaziaException();
        }
        return funcionarios;
    }

    @Override
    public Funcionario buscarFuncionarioPorId(Long id) {
        Optional<Funcionario> funcionario = repository.findById(id);
        if(funcionario.isEmpty()){
            throw new NoSuchElementException("O funcionario não existe");
        }
        return funcionario.get();
    }
}
