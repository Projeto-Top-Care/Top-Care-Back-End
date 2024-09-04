package sc.senai.topcare.controller.dto.filial;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import sc.senai.topcare.enuns.Estado;

@Data
@AllArgsConstructor
public class FilialPostDto {

    @NotNull
    String nome;

    @NotEmpty @Size(max = 9)
    String cep;

    @NotEmpty
    String cidade;

    @NotEmpty
    String bairro;

    String complemento;

    @NotEmpty
    Estado estado;

    @NotEmpty
    String nomeEndereco;

    @NotEmpty
    @Positive
    @Digits(integer = 4, fraction = 0)
    Integer numero;

    @Size(max = 50)
    String rua;

    @NotNull
    String diasDaSemana;

    @NotEmpty
    String horarioFuncionamento;
}
