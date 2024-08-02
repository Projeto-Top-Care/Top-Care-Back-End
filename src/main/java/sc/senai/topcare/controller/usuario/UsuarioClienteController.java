package sc.senai.topcare.controller.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPutDTO;
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
    public ResponseEntity<Cliente> cadastro(@RequestBody ClienteRequestPostDTO usuarioDTO){
        return usuarioService.cadastro(usuarioDTO);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Cliente> editar(@RequestBody ClienteRequestPutDTO dto,
                                          @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.editar(dto, id));
    }
}
