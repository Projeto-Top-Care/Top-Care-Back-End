package sc.senai.topcare.controller.usuario;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.topcare.service.interfaces.FormaPagamentoStrategy;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/teste")
public class FormaPagamentoController {

    private final FormaPagamentoStrategy pixStrategy;
    private final FormaPagamentoStrategy cartaoStrategy;


    @GetMapping
    public Map<String, String> formaPagamento() {
        Map<String, String> pagamentos = new HashMap<>();
        pagamentos.put("PIX", pixStrategy.pagamento().name());
        pagamentos.put("CARTAO_CREDITO", cartaoStrategy.pagamento().name());
        pagamentos.put("BOLETO", boletoStrategy.pagamento().name());

        return pagamentos;
    }

}
