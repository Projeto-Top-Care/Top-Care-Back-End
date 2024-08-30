package sc.senai.topcare.controller.dto.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.filial.FilialSimplesRequestDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.enuns.Sexo;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioResponseDTO {
    String nome;

    Long codigo;

    String email;

    String celular;

    String cpf;

    LocalDate dataNascimento;

    Sexo sexo;

    String nomeFilial;

    List<Horario> horarios;

    public FuncionarioResponseDTO(Funcionario funcionario) {
        ModelMapperUtil.map(funcionario, this);
    }

    public FuncionarioResponseDTO(Especie especie) {
        ModelMapperUtil.map(especie, this);
    }
}
