package sc.senai.topcare.controller.dto.pedido;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {
    @NotEmpty
    private Long codigo;
    @NotEmpty
    private LocalDateTime dataCompra;
    @NotEmpty
    private StatusPedido status;
    @NotEmpty
    private Double frete;
    private Double desconto;
    @NotEmpty
    private Double subTotal;
    @NotEmpty
    private Double total;
    @NotNull
    private Cliente cliente;
    @NotNull
    private Pagamento pagamento;
    @NotNull
    private Endereco endereco;
    @NotNull
    private List<QuantidadeProduto> produtos;

    public Long getClienteId() {
        return cliente.getId();
    }
}
