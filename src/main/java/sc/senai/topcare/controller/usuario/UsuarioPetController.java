package sc.senai.topcare.controller.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.service.pet.PetServiceImpl;

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
