package sc.senai.topcare.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoRequestDTO {
        private String nome;
        private String marca;
        private Long codigo;
        private String descricao;
        private List<VarianteProdutoDTO> variantes;
        private List<EspecificacaoDTO> especificacoes;
    }

