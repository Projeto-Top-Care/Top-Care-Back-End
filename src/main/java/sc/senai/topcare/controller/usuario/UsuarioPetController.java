package sc.senai.topcare.controller.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.service.implement.PetServiceImpl;
import sc.senai.topcare.service.implement.UsuarioServiceImpl;
import sc.senai.topcare.service.interfaces.PetService;
import sc.senai.topcare.service.interfaces.UsuarioService;

@RestController
@RequestMapping("usuario/pet")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UsuarioPetController{

    private final PetServiceImpl service;

    @PatchMapping("/cadastro")
    public ResponseEntity<Void> cadastrarPet(@RequestBody PetRequestDTO petDTO){
        service.cadastrar(petDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Pet> editarPet(@RequestBody PetRequestDTO dto, @PathVariable Long id){
        return ResponseEntity.ok(service.editar(dto, id));
    }
}
