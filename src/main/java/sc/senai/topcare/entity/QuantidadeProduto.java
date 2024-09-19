package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestSimplesDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoResponseSimplesDTO;

@Entity
@Table(name = "quantidade_produto")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class QuantidadeProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private VarianteProduto varianteProduto;

    private Integer quantidade;

    public QuantidadeProdutoResponseSimplesDTO paraSimplesResponseDTO(){
        return new QuantidadeProdutoResponseSimplesDTO(this.id, this.produto.getId(), this.quantidade);
    }

    public QuantidadeProduto (QuantidadeProdutoRequestDTO dto){
        this.produto = new Produto(dto.getProdutoId());
        this.varianteProduto = new VarianteProduto(dto.getVarianteProdutoId());
        this.quantidade = dto.getQuantidade();
    }

}
