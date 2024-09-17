package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.produto.VarianteProdutoDTO;
import sc.senai.topcare.enuns.TipoVariante;
import sc.senai.topcare.utils.ModelMapperUtil;

@Entity
@Table(name = "variante_produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VarianteProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cor;

    private String tamanho;

    private Integer peso;

    private Integer unidades;

    private Double preco;

    private Double desconto;

    private Integer estoque;

    public VarianteProduto (VarianteProdutoDTO dto){
        ModelMapperUtil.map(dto, this);
    }
    public VarianteProduto (Long id){
        this.id = id;
    }

}
