package sc.senai.topcare.controller.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.controller.dto.usuario.response.pet.PetServicoResponseDTO;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.service.pet.PetServiceImpl;

import java.util.NoSuchElementException;

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

    @GetMapping("/{id}")
    public ResponseEntity<PetServicoResponseDTO> buscarPet(@PathVariable Long id){
        try{
            return ResponseEntity.ok(service.buscarPetServicoPorId(id));
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
