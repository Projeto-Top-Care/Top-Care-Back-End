package sc.senai.topcare.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.enuns.TipoVariante;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VarianteProdutoDTO {
    String cor;
    String tamanho;
    Integer peso;
    Integer unidades;
    Double preco;
    Integer estoque;

}
