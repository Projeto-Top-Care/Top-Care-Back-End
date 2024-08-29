package sc.senai.topcare.controller.dto.quantidadeProduto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.entity.VarianteProduto;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeProdutoRequestDTO {

    private VarianteProduto produto;

    private Integer quantidade;
}
