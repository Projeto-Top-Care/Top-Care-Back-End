package sc.senai.topcare.controller.dto.usuario.request;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.entity.Usuario;

import java.util.List;

public record CarrinhoRequestPostDTO (
         Usuario usuario,
         List<QuantidadeProduto> produtos,
         Double desconto,
         Double frete,
         Double total,
         Double subTotal
){
}
