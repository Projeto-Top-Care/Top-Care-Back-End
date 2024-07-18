package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.LoginRequestDTO;
import sc.senai.topcare.exceptions.UsuarioNaoEncontradoException;
import sc.senai.topcare.repository.ClienteRepository;
import sc.senai.topcare.controller.dto.usuario.ClienteRequestPostDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Usuario;
import sc.senai.topcare.exceptions.UsuarioExistenteExeption;
import sc.senai.topcare.repository.UsuarioRepository;
import sc.senai.topcare.service.interfaces.UsuarioService;

import java.util.ArrayList;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final ClienteRepository clientRepository;
    private final UsuarioRepository usuarioRepository;
    @Override
    public ResponseEntity<Cliente> cadastro(ClienteRequestPostDTO usuarioDTO) {
        try{
            Optional<Cliente> usuarioOptional = clientRepository.findByCpf(usuarioDTO.cpf());

            if(usuarioOptional.isPresent()){
                throw new UsuarioExistenteExeption("O CPF já existe no sistema!");
            }

            Cliente usuario = new Cliente();
            usuario.setEnderecos(new ArrayList<>());
            usuario.setPets(new ArrayList<>());

            BeanUtils.copyProperties(usuarioDTO, usuario);
            usuario.getEnderecos().add(usuarioDTO.endereco());
            usuario.getPets().add(usuarioDTO.pet());
            clientRepository.save(usuario);

            return ResponseEntity.ok(usuario);
        }catch (UsuarioExistenteExeption e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Boolean> login(LoginRequestDTO login) {
        try{
            Optional<Usuario> usuario = usuarioRepository.findByEmail(login.email());

            if(usuario.isEmpty() || !usuario.get().getSenha().equals(login.senha())){
                throw new UsuarioNaoEncontradoException();
            }

            return ResponseEntity.ok(true);
        }catch (UsuarioNaoEncontradoException e){
            return ResponseEntity.badRequest().body(false);
        }
    }
}
