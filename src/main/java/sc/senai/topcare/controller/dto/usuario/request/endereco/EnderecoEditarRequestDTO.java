package sc.senai.topcare.controller.dto.usuario.request.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sc.senai.topcare.enuns.Estado;

@AllArgsConstructor
@Getter
public class EnderecoEditarRequestDTO {
    String cep;
    String cidade;
    String rua;
    String bairro;
    Estado estado;
    String nome;
    String complemento;
    Integer numero;
}
