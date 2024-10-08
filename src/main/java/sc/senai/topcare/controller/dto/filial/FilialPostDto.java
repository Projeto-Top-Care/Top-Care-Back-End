package sc.senai.topcare.controller.dto.filial;

import lombok.AllArgsConstructor;
import lombok.Data;
import sc.senai.topcare.enuns.Estado;

@Data
@AllArgsConstructor
public class FilialPostDto {

    String nome;
    String contato;
    String cep;
    String cidade;
    String bairro;
    String complemento;
    Estado estado;
    String nomeEndereco;
    Integer numero;
    String rua;
    String diasDaSemana;
    String horarioFuncionamento;
}
