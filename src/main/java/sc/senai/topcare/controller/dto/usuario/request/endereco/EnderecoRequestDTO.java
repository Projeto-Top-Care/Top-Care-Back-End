package sc.senai.topcare.controller.dto.usuario.request.endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sc.senai.topcare.enuns.Estado;

@AllArgsConstructor
@Getter
public class EnderecoRequestDTO {
    Long idUsuario;
    String bairro;
    String rua;
    String cidade;
    String cep;
    String nome;
    String complemento;
    Integer numero;
    Estado estado;
}
