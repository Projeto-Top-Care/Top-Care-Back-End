package sc.senai.topcare.controller.dto.usuario.response.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Pet;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetServicoResponseDTO {
    EspeciePetResponseDTO especie;
    public PetServicoResponseDTO(Pet pet){
        this.especie = new EspeciePetResponseDTO(pet.getEspecie());
    }
}
