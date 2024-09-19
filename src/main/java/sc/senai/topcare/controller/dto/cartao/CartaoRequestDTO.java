package sc.senai.topcare.controller.dto.cartao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartaoRequestDTO {
    String nomeDoCartao;
    String nomeNoCartao;
    String cpf;
    String numero;
    String validade;

}
