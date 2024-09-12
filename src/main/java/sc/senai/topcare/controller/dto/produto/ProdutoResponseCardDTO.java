package sc.senai.topcare.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.entity.VarianteProduto;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoResponseCardDTO {
    Long id;
    String nome;
    String imagem;
    Double notaAvaliacao;
    Double preco;

    public ProdutoResponseCardDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.imagem = produto.getImagens().getFirst().getCaminho();
        this.notaAvaliacao = produto.getNotaAvaliacao();
        this.preco = getMenorPreco(produto.getVariantes());
    }

    private Double getMenorPreco(List<VarianteProduto> variantes){
        Double menorPreco = 999999999.9;
        for(VarianteProduto var : variantes){
            if(var.getPreco() < menorPreco){
                menorPreco = var.getPreco();
            }
        }
        return menorPreco;
    }
}
