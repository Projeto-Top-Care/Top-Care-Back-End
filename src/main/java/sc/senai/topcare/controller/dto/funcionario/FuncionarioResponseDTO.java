package sc.senai.topcare.controller.dto.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.filial.FilialSimplesRequestDTO;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Filial;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.utils.ModelMapperUtil;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioResponseDTO {
    Long id;
    String nome;

    public FuncionarioResponseDTO(Funcionario funcionario) {
        ModelMapperUtil.map(funcionario, this);
    }

    public FuncionarioResponseDTO(Especie especie) {
        ModelMapperUtil.map(especie, this);
    }
}
