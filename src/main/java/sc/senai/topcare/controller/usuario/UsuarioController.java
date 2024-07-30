package sc.senai.topcare.controller.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.LoginRequestDTO;
import sc.senai.topcare.controller.dto.usuario.response.LoginResonseDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.service.implement.UsuarioServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    protected final UsuarioServiceImpl usuarioService;

    @PostMapping("/login")
    public ResponseEntity<LoginResonseDTO> login(@RequestBody LoginRequestDTO login){
        return usuarioService.login(login);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuario(@PathVariable Long id){
        return usuarioService.buscarUsuario(id);
    }
}
