package sc.senai.topcare.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
public class ProdutoRequestDTO {
        private String nome;
//        private Double notaAvaliacao;
        private Long imagemId;
        private String marca;
        private List<VarianteProdutoDTO> variantes;
        private Boolean disponivel;
        private Long codigo;
//        private Integer estoque;
//        private Boolean temVariante;
//        private Double preco;
//        private Double desconto;
//        private Double precoDesconto;
//        private Integer quantidadeVendas;
        private List<String> descricao;
        private List<EspecificacaoDTO> especificacoes;
//        private List<AvaliacaoDTO> avaliacoes;
//        private List<String> tags;
    }

