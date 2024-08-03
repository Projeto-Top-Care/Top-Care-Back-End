package sc.senai.topcare.controller.dto.usuario.request.pet;

import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Porte;

public record PetRequestDTO(
    Long idUsuario,
    Long id,
    String raca,
    Long idEspecie,
    Porte porte,
    String nome
) {
}
