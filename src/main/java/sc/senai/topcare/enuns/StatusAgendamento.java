package sc.senai.topcare.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusAgendamento {
    AGUARDANDO_CLIENTE("Aguardando cliente"),
    EM_ANDAMENTO("Em andamento"),
    AGUARDANDO_RETIRADA("Aguardando retirada do pet"),
    CONCLUIDO("Concluído");

    private final String NOME;
}
