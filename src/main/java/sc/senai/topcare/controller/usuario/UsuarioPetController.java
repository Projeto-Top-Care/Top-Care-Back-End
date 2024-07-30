package sc.senai.topcare.controller.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.service.implement.UsuarioServiceImpl;

@RestController
@RequestMapping("usuario/pet")
public class UsuarioPetController extends UsuarioController{
    public UsuarioPetController(UsuarioServiceImpl usuarioService) {
        super(usuarioService);
    }
    @PatchMapping("/cadastro")
    public ResponseEntity<Boolean> cadastrarPet(@RequestBody PetRequestDTO petDTO){
        return usuarioService.cadastrarPet(petDTO);
    }
}
