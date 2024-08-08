package sc.senai.topcare.service.implement;

import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.MetodoPagamento;
import sc.senai.topcare.service.interfaces.FormaPagamentoStrategy;

@Service
public class CartaoStrategy implements FormaPagamentoStrategy {

    @Override
    public String pagamento() {
        return "Pagamento feito por Cartão de Crédito";
    }
}
