package sc.senai.topcare.service.interfaces;

import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.MetodoPagamento;

@Service
public interface FormaPagamentoStrategy {
    String pagamento();

}
