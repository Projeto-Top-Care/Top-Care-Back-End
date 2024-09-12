package sc.senai.topcare.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum Role {
    BASIC("Básico"),
    FUNCIONARIO("Funcionario"),
    ADMIN("Admin");

    private final String NOME;
}
