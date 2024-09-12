package sc.senai.topcare.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Categoria;
import sc.senai.topcare.entity.Especie;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestPutDTO {
    private String nome;
    private String marca;
    private Long codigo;
    private String descricao;
    private Categoria categoria;
    private List<Especie> especies;
    private List<VarianteProdutoDTO> variantes;
    private List<EspecificacaoDTO> especificacoes;
    private List<String> imagensDeletar;
}
