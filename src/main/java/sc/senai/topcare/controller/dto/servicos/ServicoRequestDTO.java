package sc.senai.topcare.controller.dto.servicos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.VarianteServico;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServicoRequestDTO {
    String nome;
    List<Long> especiesId;
    String descricao;
    List<Long> funcionariosId;
    List<VarianteServico> variantes;
}
