package sc.senai.topcare.controller.dto.pedido;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.enuns.StatusPedido;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {

    @NotEmpty
    private Long codigo;
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
    private StatusPedido status;


    public Long getClienteId() {
        return cliente.getId();
    }

    public Long getPagamentoId() {
        return pagamento.getId();
    }

    public Long getEnderecoId() {
        return endereco.getId();
    }

    public List<Long> getProdutosId() {
        return produtos.stream().map(QuantidadeProduto::getId).toList();
    }
}
