package sc.senai.topcare.controller.dto.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import sc.senai.topcare.enuns.Role;
import sc.senai.topcare.enuns.Sexo;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class FuncionarioPostDto {
    String nome;

    Long codigo;

    Role role;

    String email;

    String celular;

    String cpf;

    LocalDate dataNascimento;

    Sexo sexo;

    String senha;

    String nomeFilial;
}