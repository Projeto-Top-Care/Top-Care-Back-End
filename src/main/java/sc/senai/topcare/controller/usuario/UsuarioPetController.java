package sc.senai.topcare.controller.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.service.implement.UsuarioServiceImpl;

@RestController
@RequestMapping("usuario/pet")
@CrossOrigin("*")
public class UsuarioPetController extends UsuarioController{
    public UsuarioPetController(UsuarioServiceImpl usuarioService) {
        super(usuarioService);
    }
    @PatchMapping("/cadastro")
    public ResponseEntity<Boolean> cadastrarPet(@RequestBody PetRequestDTO petDTO){
        return usuarioService.cadastrarPet(petDTO);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Pet> editarPet(@RequestBody PetRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.editarPet(dto, id));
    }
}
