package sc.senai.topcare.controller.dto.carrinho;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.entity.Usuario;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoRequestDTO {

    public Long usuarioId;
    public List<QuantidadeProduto> produtos;
    public Double subTotal;
    public Double total;

}
