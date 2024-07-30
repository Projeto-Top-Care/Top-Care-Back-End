package sc.senai.topcare.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.*;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Usuario;

@Service
public interface UsuarioService {
    ResponseEntity<Cliente> cadastro(ClienteRequestPostDTO usuarioDTO);

    ResponseEntity<LoginResonseDTO> login(LoginRequestDTO login);


    ResponseEntity<Cliente> buscarUsuario(Long id);

    ResponseEntity<Boolean> cadastrarEndereco(EnderecoRequestDTO enderecoDTO);

    ResponseEntity<Boolean> cadastrarPet(PetRequestDTO petDTO);
}
