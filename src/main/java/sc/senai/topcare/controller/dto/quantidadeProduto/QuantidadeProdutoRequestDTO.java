package sc.senai.topcare.controller.dto.quantidadeProduto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Produto;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeProdutoRequestDTO {

    private Produto produto;

    private Integer quantidade;
}
