package sc.senai.topcare.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.TipoVariante;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VarianteProdutoDTO {
    private TipoVariante tipoVariante;
    private Double preco;
    private Double desconto;
    private Integer estoque;
    private Double precoDesconto;

}
