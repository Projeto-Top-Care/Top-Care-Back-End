package sc.senai.topcare.service.implement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.MetodoPagamento;
import sc.senai.topcare.service.interfaces.FormaPagamentoStrategy;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl {

    private FormaPagamentoStrategy formaPagamentoStrategy;

    //Construtor
    public PedidoServiceImpl(MetodoPagamento metodoPagamento){
        // Inicializa 'formaPagamentoStrategy' com a estratégia
        // obtida do enum 'MetodoPagamento'
        this.formaPagamentoStrategy = metodoPagamento.getStrategy();
    }

    // Método que retorna o resultado do pagamento usando a
    // estratégia configurada
    public String getFormaPagamento(){
        // Chama o método 'pagamento' da estratégia de pagamento
        // e retorna o resultado
        return this.formaPagamentoStrategy.pagamento();
    }
}
