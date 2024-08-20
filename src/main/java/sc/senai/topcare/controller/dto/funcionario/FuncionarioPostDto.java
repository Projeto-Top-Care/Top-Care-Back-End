package sc.senai.topcare.controller.dto.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import sc.senai.topcare.entity.Role;
import sc.senai.topcare.entity.Sexo;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class FuncionarioPostDto {
    String nome;

    Role role;

    String email;

    String celular;

    String cpf;

    LocalDate dataNascimento;

    Sexo sexo;

    String senha;

    Long idFilial;
}