package sc.senai.topcare.controller.usuario;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.topcare.entity.MetodoPagamento;
import sc.senai.topcare.service.interfaces.FormaPagamentoStrategy;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/teste")
public class FormaPagamentoController {

    private final FormaPagamentoStrategy pixStrategy;
    private final FormaPagamentoStrategy cartaoStrategy;
    private final FormaPagamentoStrategy boletoStrategy;
    private final FormaPagamentoStrategy payPalStrategy;

    @GetMapping
    public Map<String, String> formaPagamento() {
        Map<String, String> pagamentos = new HashMap<>();
        pagamentos.put("PIX", pixStrategy.pagamento().getNOME());
        pagamentos.put("CARTAO_CREDITO", cartaoStrategy.pagamento().getNOME());
        pagamentos.put("BOLETO", boletoStrategy.pagamento().getNOME());
        pagamentos.put("PAYPAL", payPalStrategy.pagamento().getNOME());
        return pagamentos;
    }

}
