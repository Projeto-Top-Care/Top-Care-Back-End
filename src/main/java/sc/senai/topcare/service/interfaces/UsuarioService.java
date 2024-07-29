package sc.senai.topcare.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.LoginRequestDTO;
import sc.senai.topcare.controller.dto.usuario.LoginResonseDTO;
import sc.senai.topcare.entity.Cliente;

@Service
public interface UsuarioService {
    ResponseEntity<Cliente> cadastro(ClienteRequestPostDTO usuarioDTO);

    ResponseEntity<LoginResonseDTO> login(LoginRequestDTO login);


}
