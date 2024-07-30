package sc.senai.topcare.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoEditarRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.LoginRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.controller.dto.usuario.response.LoginResonseDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.entity.Cliente;

@Service
public interface UsuarioService {
    ResponseEntity<Cliente> cadastro(ClienteRequestPostDTO usuarioDTO);

    ResponseEntity<LoginResonseDTO> login(LoginRequestDTO login);


    ResponseEntity<UsuarioResponseDTO> buscarUsuario(Long id);

    ResponseEntity<Boolean> cadastrarEndereco(EnderecoRequestDTO enderecoDTO);

    ResponseEntity<Boolean> cadastrarPet(PetRequestDTO petDTO);

    ResponseEntity<Boolean> editarEndereco(EnderecoEditarRequestDTO enderecoDTO);
}
