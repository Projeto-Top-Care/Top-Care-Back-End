package sc.senai.topcare.controller.usuario;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPutDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.service.cliente.ClienteService;

@RestController
@CrossOrigin("*")
@RequestMapping("usuario/cliente")
@RequiredArgsConstructor
public class UsuarioClienteController{

    private final ClienteService clienteService;

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioResponseDTO> cadastro(@Valid @RequestBody ClienteRequestPostDTO usuarioDTO){
        clienteService.cadastro(usuarioDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editar(@RequestBody ClienteRequestPutDTO dto,
                                          @PathVariable Long id){
        return ResponseEntity.ok(clienteService.editar(dto, id));
    }
}
