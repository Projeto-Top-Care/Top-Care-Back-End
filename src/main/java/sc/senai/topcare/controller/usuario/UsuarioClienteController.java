package sc.senai.topcare.controller.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPutDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.service.implement.UsuarioServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("usuario/cliente")
public class UsuarioClienteController extends UsuarioController{

    public UsuarioClienteController(UsuarioServiceImpl usuarioService) {
        super(usuarioService);
    }
    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioResponseDTO> cadastro(@RequestBody ClienteRequestPostDTO usuarioDTO){
        usuarioService.cadastro(usuarioDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editar(@RequestBody ClienteRequestPutDTO dto,
                                          @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.editar(dto, id));
    }
}
