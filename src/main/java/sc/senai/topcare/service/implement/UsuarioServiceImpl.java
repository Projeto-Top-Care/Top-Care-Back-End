package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPutDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.usuario.LoginRequestDTO;
import sc.senai.topcare.controller.dto.usuario.response.LoginResonseDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.entity.Endereco;
import sc.senai.topcare.exceptions.UsuarioNaoEncontradoException;
import sc.senai.topcare.repository.ClienteRepository;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Usuario;
import sc.senai.topcare.exceptions.UsuarioExistenteExeption;
import sc.senai.topcare.repository.UsuarioRepository;
import sc.senai.topcare.service.interfaces.UsuarioService;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final ClienteRepository clientRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public void cadastro(ClienteRequestPostDTO usuarioDTO) {
        try{
            if(clientRepository.existsByCpf(usuarioDTO.getCpf())){
                throw new UsuarioExistenteExeption("O CPF já existe no sistema!");
            }
            Cliente usuario = new Cliente(usuarioDTO);
            clientRepository.save(usuario);
        }catch (UsuarioExistenteExeption e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public LoginResonseDTO login(LoginRequestDTO login) {
        try{
            Optional<Usuario> usuario = usuarioRepository.findByEmail(login.email());

            if(usuario.isEmpty() || !usuario.get().getSenha().equals(login.senha())){
                throw new UsuarioNaoEncontradoException();
            }

            return new LoginResonseDTO(usuario.get().getId());
        }catch (UsuarioNaoEncontradoException e){
            return null;
        }
    }
    @Override
    public UsuarioResponseDTO buscarUsuario(Long id) {
        Cliente optionalCliente = buscarCliente(id);
        return ModelMapperUtil.getModelMapper().map(optionalCliente, UsuarioResponseDTO.class);

    }
    @Override
    public Cliente salvar(Cliente cliente){
        return clientRepository.save(cliente);
    }

    @Override
    public Cliente editar(ClienteRequestPutDTO dto, Long id) {
        Cliente cliente = buscarCliente(id);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, cliente);
        return clientRepository.save(cliente);
    }

    @Override
    public Cliente buscarCliente(Long id){
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}