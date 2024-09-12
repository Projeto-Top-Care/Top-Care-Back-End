package sc.senai.topcare.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusPedido {
    CRIADO("Pedido criado"),
    PAGAMENTO_APROVADO("Pagamento aprovado"),
    SEPARANDO("Separando pedido"),
    TRANSPORTADORA("Pedido com a Transportadora"),
    ENTREGE("Pedido Entregue");

    private final String NOME;

}
