package sc.senai.topcare.controller.dto.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.utils.ModelMapperUtil;

@AllArgsConstructor
@Data
public class FuncionarioSimplesResponseDto {

        Long id;
        String nome;
        String cpf;
        String email;

        public FuncionarioSimplesResponseDto(Funcionario funcionario) {
            ModelMapperUtil.map(funcionario, this);
        }

        public FuncionarioSimplesResponseDto(Especie especie) {
            ModelMapperUtil.map(especie, this);
        }
}
