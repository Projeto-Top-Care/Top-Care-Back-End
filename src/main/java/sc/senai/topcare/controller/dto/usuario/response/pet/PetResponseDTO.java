package sc.senai.topcare.controller.dto.usuario.response.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.utils.ModelMapperUtil;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetResponseDTO {
    Long id;
    String especie;
    String raca;
    String porte;

    public PetResponseDTO(Pet pet){
        this.id = pet.getId();
        this.raca = pet.getRaca();
        this.especie = pet.getEspecie().getNome();
        this.porte = pet.getPorte().getNOME();
    }
}
