package sc.senai.topcare.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Porte {
    MINI("Mini"),
    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande"),
    GIGANTE("Gigante");

    private final String NOME;
}
