package sc.senai.topcare.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoEditarRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Endereco;
import sc.senai.topcare.exceptions.EnderecoNaoEncontradoException;
import sc.senai.topcare.repository.EnderecoRepository;
import sc.senai.topcare.service.interfaces.EnderecoService;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;
    private final UsuarioServiceImpl usuarioService;

    @Override
    public void cadastrar(EnderecoRequestDTO enderecoDTO) {
        Cliente cliente = usuarioService.buscarCliente(enderecoDTO.getIdUsuario());
        cliente.getEnderecos().add(new Endereco(enderecoDTO));
        usuarioService.salvar(cliente);
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
    public Boolean editar(EnderecoEditarRequestDTO dto, Long id) {
        Endereco endereco = buscar(id);
        ModelMapperUtil.getModelMapper().map(dto, endereco);
        salvar(endereco);
        return true;
    }

    @Override
    public String deletar(Long id) {
        String nome = buscar(id).getNome();
        repository.deleteById(id);
        return nome + " excluido!";
    }


}
