package sc.senai.topcare.controller.dto.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.conjuntas.IdNomeResponseDTO;
import sc.senai.topcare.entity.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoCompletoResponseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double notaAvaliacao = 0.0;

    private List<Imagem> imagens = new ArrayList<>();

    private String marca;

    private Categoria categoria;

    private Boolean disponivel = true;

    private Long codigo;

    private Integer quantidadeVendas = 0;

    private String descricao;

    private List<VarianteProduto> variantes;

    private List<Especificacao> especificacoes;

    private List<IdNomeResponseDTO> especies;

    private List<Avaliacao> avaliacoes;

    public ProdutoCompletoResponseDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.notaAvaliacao = produto.getNotaAvaliacao();
        this.imagens = produto.getImagens();
        this.marca = produto.getMarca();
        this.categoria = produto.getCategoria();
        this.disponivel = produto.getDisponivel();
        this.codigo = produto.getCodigo();
        this.quantidadeVendas = produto.getQuantidadeVendas();
        this.descricao = produto.getDescricao();
        this.variantes = produto.getVariantes();
        this.especificacoes = produto.getEspecificacoes();
        this.especies = produto.getEspecies().stream().map(IdNomeResponseDTO::new).toList();
        this.avaliacoes = produto.getAvaliacoes();
    }
}
