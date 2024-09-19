package sc.senai.topcare.controller.dto.usuario.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Pedido;
import sc.senai.topcare.entity.QuantidadeProduto;

import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PedidoCardResponseDTO{
    Long id;
    String dataCompra;
    Long codigo;
    String status;
    Double total;
    List<QuantidadeProduto> produtos;

    public PedidoCardResponseDTO(Pedido pedido){
        this.id = pedido.getId();
        this.dataCompra = pedido.getDataCompra().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.codigo = pedido.getCodigo();
        this.status = pedido.getStatus().getNOME();
        this.total = pedido.getTotal();
        this.produtos = pedido.getProdutos();
    }
}
