package sc.senai.topcare.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.VarianteProduto;
import sc.senai.topcare.enuns.TipoVariante;
import sc.senai.topcare.utils.ModelMapperUtil;

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

    public VarianteProdutoDTO(VarianteProduto varianteProduto) {
        ModelMapperUtil.map(varianteProduto, this);
    }
}
