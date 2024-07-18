package sc.senai.topcare.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MetodoPagamento {
    PIX("Pix"),
    CARTAO_CREDITO("Cartão de crédito"),
    BOLETO("Boleto bancário");
    
    private final String NOME;
}
