package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;

import java.util.List;

@Entity
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double notaAvaliacao = 0.0;

    @OneToMany
    @JoinColumn(name = "id_produto")
    private List<Imagem> imagens;

    private String marca;

    private Boolean disponivel = true;

    private Long codigo;

    private Integer quantidadeVendas = 0;

    private String descricao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    private List<VarianteProduto> variantes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    private List<Especificacao> especificacoes;

    @OneToMany
    @JoinColumn(name = "id_produto")
    private List<Avaliacao> avaliacoes;

    public Produto(ProdutoRequestDTO dto){
        this.nome = dto.getNome();
        this.marca = dto.getMarca();
        this.codigo = dto.getCodigo();
        this.descricao = dto.getDescricao();
        this.variantes = dto.getVariantes().stream().map(VarianteProduto::new).toList();
        this.especificacoes = dto.getEspecificacoes().stream().map(Especificacao::new).toList();
    }

}
