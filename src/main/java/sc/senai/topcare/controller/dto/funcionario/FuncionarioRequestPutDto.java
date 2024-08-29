package sc.senai.topcare.controller.dto.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import sc.senai.topcare.enuns.Sexo;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class FuncionarioRequestPutDto {
    String nome;

    String email;

    String celular;

    LocalDate dataNascimento;

    Sexo sexo;

    String nomeFilial;
}
