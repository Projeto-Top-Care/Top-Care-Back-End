package sc.senai.topcare.controller.dto.filial;

import lombok.AllArgsConstructor;
import lombok.Data;
import sc.senai.topcare.enuns.Estado;

@AllArgsConstructor
@Data
public class FilialCompletaResponseDto {

    String nome;
    Long id;
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
