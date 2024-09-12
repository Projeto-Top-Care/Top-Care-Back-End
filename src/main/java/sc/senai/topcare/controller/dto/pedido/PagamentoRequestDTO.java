package sc.senai.topcare.controller.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.enuns.MetodoPagamento;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoRequestDTO {

    private MetodoPagamento metodoPagamento;
    private Integer parcelas;
    private Boolean pago;
}
