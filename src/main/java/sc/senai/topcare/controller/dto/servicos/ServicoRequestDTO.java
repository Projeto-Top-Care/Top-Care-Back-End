package sc.senai.topcare.controller.dto.servicos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.entity.VarianteServico;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicoRequestDTO {
    String nome;
    List<Especie> especies;
    String categoria;
    String descricao;
    List<Funcionario> funcionarios;
    List<VarianteServico> variantes;
}
