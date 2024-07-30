package sc.senai.topcare.controller.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPostDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.service.implement.UsuarioServiceImpl;

@RestController
@RequestMapping("usuario/cliente")
public class UsuarioClienteController extends UsuarioController{

    public UsuarioClienteController(UsuarioServiceImpl usuarioService) {
        super(usuarioService);
    }
    @PostMapping("/cadastro")
    public ResponseEntity<Cliente> cadastro(@RequestBody ClienteRequestPostDTO usuarioDTO){
        return usuarioService.cadastro(usuarioDTO);
    }
}
