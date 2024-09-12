package sc.senai.topcare.controller.dto.usuario.response.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Especie;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EspeciePetResponseDTO {
    List<ServicoPetResponseDTO> servicos;

    public EspeciePetResponseDTO(Especie especie){
        this.servicos = especie.getServicos().stream().map(ServicoPetResponseDTO::new).toList();
    }
}
