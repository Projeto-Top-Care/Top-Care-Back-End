package sc.senai.topcare.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoVariante {
    TAMANHO("Tamanho"),
    COR("Cor"),
    PESO("Peso"),
    UNIDADE("Unidade");

    private final String NOME;
}
