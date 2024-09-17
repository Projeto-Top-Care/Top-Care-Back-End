package sc.senai.topcare.service.cliente;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPutDTO;
import sc.senai.topcare.entity.Cliente;

@Service
public interface ClienteService {
    void cadastro(ClienteRequestPostDTO usuarioDTO);
    Cliente editar(ClienteRequestPutDTO dto, Long id);
    Cliente buscarCliente(Long id);
    Cliente salvar(Cliente cliente);

}
