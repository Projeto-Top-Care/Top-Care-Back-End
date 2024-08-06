package sc.senai.topcare.service.implement;

import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.MetodoPagamento;
import sc.senai.topcare.service.interfaces.FormaPagamentoStrategy;

@Service
public class BoletoStrategy implements FormaPagamentoStrategy {

    @Override
    public MetodoPagamento pagamento() {
        return MetodoPagamento.BOLETO;
    }

}
