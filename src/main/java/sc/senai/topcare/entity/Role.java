package sc.senai.topcare.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    BASIC("Básico"),
    FUNCIONARIO("Funcionario"),
    ADMIN("Admin");

    private final String NOME;
}
