package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import sc.senai.topcare.controller.dto.pedido.PedidoRequestDTO;
import sc.senai.topcare.controller.dto.pedido.PedidoResponseDTO;
import sc.senai.topcare.utils.ModelMapperUtil;
import sc.senai.topcare.enuns.StatusPedido;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long codigo;

    private LocalDateTime dataCompra;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private Double frete;
    private Double desconto;
    private Double subTotal;
    private Double total;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Pagamento pagamento;

    @ManyToOne
    private Endereco endereco;

    @OneToMany
    @JoinColumn(name = "id_pedido")
    private List<QuantidadeProduto> produtos;

    public Pedido(PedidoRequestDTO dto){
        ModelMapperUtil.map(dto, this);
    }

    public PedidoResponseDTO editar(PedidoRequestDTO dto) {
        BeanUtils.copyProperties(dto, this);
        return new PedidoResponseDTO(this);
    }

}
