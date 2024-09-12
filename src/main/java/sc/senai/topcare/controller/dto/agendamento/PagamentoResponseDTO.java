package sc.senai.topcare.controller.dto.agendamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Pagamento;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagamentoResponseDTO {

    String metodoPagamento;
    Integer parcelas;
    Boolean pago;

    public PagamentoResponseDTO(Pagamento pagamento) {
        this.metodoPagamento = pagamento.getMetodoPagamento().getNOME();
        this.parcelas = pagamento.getParcelas();
        this.pago = pagamento.getPago();
    }

}
