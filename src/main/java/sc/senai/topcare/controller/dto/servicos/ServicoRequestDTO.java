package sc.senai.topcare.controller.dto.servicos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.entity.VarianteServico;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServicoRequestDTO {
    String nome;
    List<Especie> especies;
    String descricao;
    List<Funcionario> funcionarios;
    List<VarianteServico> variantes;
}
