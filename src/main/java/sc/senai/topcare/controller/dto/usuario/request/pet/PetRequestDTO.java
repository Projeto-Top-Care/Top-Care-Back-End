package sc.senai.topcare.controller.dto.usuario.request.pet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Porte;
@AllArgsConstructor
@Getter
public class PetRequestDTO {
    Long idUsuario;
    Long id;
    String raca;
    Long idEspecie;
    Porte porte;
    String nome;
}
