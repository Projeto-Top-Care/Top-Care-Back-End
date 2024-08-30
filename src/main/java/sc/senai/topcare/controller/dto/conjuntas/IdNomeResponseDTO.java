package sc.senai.topcare.controller.dto.conjuntas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Funcionario;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdNomeResponseDTO {
    Long id;
    String nome;

    public IdNomeResponseDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
    }

    public IdNomeResponseDTO(Especie especie) {
        this.id = especie.getId();
        this.nome = especie.getNome();
    }
}
