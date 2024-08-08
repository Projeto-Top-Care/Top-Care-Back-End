package sc.senai.topcare.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sc.senai.topcare.service.implement.CartaoStrategy;
import sc.senai.topcare.service.interfaces.FormaPagamentoStrategy;
import sc.senai.topcare.service.implement.BoletoStrategy;
import sc.senai.topcare.service.implement.PixStrategy;

@AllArgsConstructor
@Getter
public enum MetodoPagamento {
    PIX,
    CARTAO_CREDITO,
    BOLETO;

    // Método para obter a estratégia com base no enum
    public FormaPagamentoStrategy getStrategy() {
        return switch (this) {
            case CARTAO_CREDITO -> new CartaoStrategy();
            case BOLETO -> new BoletoStrategy();
            case PIX -> new PixStrategy();
        };
    }
}
