package sc.senai.topcare.controller.dto.quantidadeProduto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeProdutoResponseSimplesDTO {

    Long id;

    private Long produtoId;

    private Integer quantidade;

}
