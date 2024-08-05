package sc.senai.topcare.controller.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Estado;
import sc.senai.topcare.entity.Filial;
import sc.senai.topcare.entity.Sexo;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRequestDTO {
    private String nome;
    private String celular;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private Sexo sexo;
    private Filial filial;
}
