package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;

import java.util.ArrayList;
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
    private List<Imagem> imagens = new ArrayList<>();

    private String marca;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

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
        this.categoria = dto.getCategoria();
        this.variantes = dto.getVariantes().stream().map(VarianteProduto::new).toList();
        this.especificacoes = dto.getEspecificacoes().stream().map(Especificacao::new).toList();
    }

}
