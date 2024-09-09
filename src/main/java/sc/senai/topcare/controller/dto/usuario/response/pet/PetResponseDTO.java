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
    String imagem;
    String nome;
    String especie;
    String raca;
    String porte;

    public PetResponseDTO(Pet pet){
        this.id = pet.getId();
//        this.imagem = pet.getImagem().getCaminho() == null ?  "": pet.getImagem().getCaminho();
        this.nome = pet.getNome();
        this.raca = pet.getRaca();
        this.especie = pet.getEspecie().getNome();
        this.porte = pet.getPorte().getNOME();
    }
}
