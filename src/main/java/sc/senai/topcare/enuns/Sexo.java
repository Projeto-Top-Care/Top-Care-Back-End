package sc.senai.topcare.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_INFORMAR("Não informar");

    public final String NOME;
}