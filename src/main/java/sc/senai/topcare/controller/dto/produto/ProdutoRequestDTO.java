package sc.senai.topcare.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Categoria;
import sc.senai.topcare.entity.Especie;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoRequestDTO {
        private String nome;
        private String marca;
        private Long codigo;
        private String descricao;
        private List<Especie> especies;
        private Categoria categoria;
        private List<VarianteProdutoDTO> variantes;
        private List<EspecificacaoDTO> especificacoes;
    }

