package sc.senai.topcare.controller.dto.quantidadeProduto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeProdutoRequestSimplesDTO {

    private Long produtoId;

    private Integer quantidade;
}
