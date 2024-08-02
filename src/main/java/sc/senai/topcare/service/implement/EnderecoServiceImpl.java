package sc.senai.topcare.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.entity.Endereco;
import sc.senai.topcare.exceptions.EnderecoNaoEncontradoException;
import sc.senai.topcare.repository.EnderecoRepository;
import sc.senai.topcare.service.interfaces.EnderecoService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;

    @Override
    public Endereco cadastrar(EnderecoRequestDTO enderecoDTO) {
        return null;
    }

    @Override
    public Endereco buscar(Long id) {
        try{
            return repository.findById(id).orElseThrow(EnderecoNaoEncontradoException::new);
        }catch (EnderecoNaoEncontradoException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void salvar(Endereco endereco) {
        repository.save(endereco);
    }

    @Override
    public String deletar(Long id) {
        String nome = buscar(id).getNome();
        repository.deleteById(id);
        return nome + " excluido!";
    }


}
