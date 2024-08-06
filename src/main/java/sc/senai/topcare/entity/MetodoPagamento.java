package sc.senai.topcare.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MetodoPagamento {
    PIX("Pix"),
    CARTAO_CREDITO("Cartão de crédito"),
    BOLETO("Boleto bancário"),
    CARTAO_DEBITO("CARTAO");
    
    private final String NOME;
}
