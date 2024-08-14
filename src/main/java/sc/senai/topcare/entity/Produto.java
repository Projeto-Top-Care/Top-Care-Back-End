package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Double notaAvaliacao;

    @OneToOne
    private File imagem;

    private String marca;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    private List<VarianteProduto> variantes;

    private Boolean disponivel;

    private Long codigo;

    private Integer estoque;

    private Boolean temVariante;

    private Double preco;

    private Double desconto;

    private Double precoDesconto;

    private Integer quantidadeVendas;

    @ElementCollection
    private List<String> descricao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    private List<Especificacao> especificacao;

    @OneToMany
    @JoinColumn(name = "id_produto")
    private List<Avaliacao> avaliacao;

    @ElementCollection
    private List<String> tags;
}
