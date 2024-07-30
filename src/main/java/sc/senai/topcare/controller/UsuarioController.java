package sc.senai.topcare.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.*;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Usuario;
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
    public ResponseEntity<LoginResonseDTO> login(@RequestBody LoginRequestDTO login){
        return usuarioService.login(login);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Cliente> buscarUsuario(@PathVariable Long id){
        return usuarioService.buscarUsuario(id);
    }

    @PostMapping("/cadastrarEndereco")
    public ResponseEntity<Boolean> cadastrarEndereco(@RequestBody EnderecoRequestDTO enderecoDTO){
        return  usuarioService.cadastrarEndereco(enderecoDTO);
    }

    @PostMapping("/cadastrarPet")
    public ResponseEntity<Boolean> cadastrarPet(@RequestBody PetRequestDTO petDTO){
        return usuarioService.cadastrarPet(petDTO);
    }
}
