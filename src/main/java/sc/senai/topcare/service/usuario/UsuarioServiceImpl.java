package sc.senai.topcare.service.usuario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.usuario.LoginRequestDTO;
import sc.senai.topcare.controller.dto.usuario.response.LoginResonseDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.exceptions.UsuarioNaoEncontradoException;
import sc.senai.topcare.entity.Usuario;
import sc.senai.topcare.repository.UsuarioRepository;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public LoginResonseDTO login(LoginRequestDTO login) {
        try{
            Optional<Usuario> usuario = usuarioRepository.findByEmail(login.email());

            if(usuario.isEmpty() || !usuario.get().getSenha().equals(login.senha())){
                throw new UsuarioNaoEncontradoException();
            }
            return new LoginResonseDTO(usuario.get().getId(), usuario.get().getRole());
        }catch (UsuarioNaoEncontradoException e){
            return null;
        }
    }

    @Override
    public UsuarioResponseDTO buscarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
        ModelMapperUtil.map(usuario, UsuarioResponseDTO.class);
        return new UsuarioResponseDTO(usuario);
    }

}