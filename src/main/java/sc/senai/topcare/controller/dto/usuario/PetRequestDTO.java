package sc.senai.topcare.controller.dto.usuario;

import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Porte;

public record PetRequestDTO(
    Long idUsuario,
    String raca,
    Especie especie,
    Porte porte,
    String nome
) {
}
