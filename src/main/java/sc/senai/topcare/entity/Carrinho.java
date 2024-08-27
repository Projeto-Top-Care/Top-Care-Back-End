package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.carrinho.CarrinhoResponseDTO;

import java.util.List;

@Entity
@Table(name = "carrinho")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "id_carrinho")
    private List<QuantidadeProduto> produtos;

    private Double desconto;

    private Double frete;

    private Double total;

    private Double subTotal;

    public CarrinhoResponseDTO paraResponseDTO(){
        return new CarrinhoResponseDTO(this.id, this.usuario.getId(), this.produtos, this.subTotal, this.desconto, this.total);
    }
}
