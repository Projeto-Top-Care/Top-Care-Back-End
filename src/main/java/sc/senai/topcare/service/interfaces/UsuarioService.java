package sc.senai.topcare.service.interfaces;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPutDTO;
import sc.senai.topcare.controller.dto.usuario.request.usuario.LoginRequestDTO;
import sc.senai.topcare.controller.dto.usuario.response.LoginResonseDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.entity.Cliente;

@Service
public interface UsuarioService {
    LoginResonseDTO login(LoginRequestDTO login);
    UsuarioResponseDTO buscarUsuario(Long id);

}
