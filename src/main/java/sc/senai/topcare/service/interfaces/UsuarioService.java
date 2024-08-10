package sc.senai.topcare.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPutDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoEditarRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.usuario.LoginRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.controller.dto.usuario.response.LoginResonseDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Pet;

@Service
public interface UsuarioService {
    void cadastro(ClienteRequestPostDTO usuarioDTO);
    LoginResonseDTO login(LoginRequestDTO login);
    UsuarioResponseDTO buscarUsuario(Long id);
    Cliente editar(ClienteRequestPutDTO dto, Long id);
    Cliente buscarCliente(Long id);
    Cliente salvar(Cliente cliente);
}
