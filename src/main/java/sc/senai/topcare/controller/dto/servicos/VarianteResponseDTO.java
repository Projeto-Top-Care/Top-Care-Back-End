package sc.senai.topcare.controller.dto.servicos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.VarianteServico;
import sc.senai.topcare.utils.ModelMapperUtil;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VarianteResponseDTO {
    String nome;

    String tipo;

    Double preco;

    public VarianteResponseDTO(VarianteServico variante){
        ModelMapperUtil.map(variante, this);
    }
}
