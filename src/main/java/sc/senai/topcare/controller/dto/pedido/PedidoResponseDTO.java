package sc.senai.topcare.controller.dto.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.enuns.StatusPedido;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {
    private Long id;
    private Long codigo;
    private String dataCompra;
    private String status;
    private Double frete;
    private Double desconto;
    private Double total;
    private Pagamento pagamento;
    private Endereco endereco;
    private List<QuantidadeProduto> produtos;


    public PedidoResponseDTO(Pedido pedido) {
        ModelMapperUtil.map(pedido, this);
        this.status = pedido.getStatus().getNOME();
        this.dataCompra = pedido.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
