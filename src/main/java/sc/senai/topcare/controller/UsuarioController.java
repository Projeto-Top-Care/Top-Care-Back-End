package sc.senai.topcare.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.LoginRequestDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.service.implement.UsuarioServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<Cliente> cadastro(@RequestBody ClienteRequestPostDTO usuarioDTO){
        return usuarioService.cadastro(usuarioDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequestDTO login){
        return usuarioService.login(login);
    }

}
