package sc.senai.topcare.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusAgendamento {
    AGUARDANDO_CLIENTE("Aguardando cliente"),
    EM_ANDAMENTO("Em andamento"),
    AGUARDANDO_RETIRADA("Aguardando retirada do pet");

    private final String NOME;
}
