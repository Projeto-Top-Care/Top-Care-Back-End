package sc.senai.topcare.controller.dto.usuario.response.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.entity.VarianteServico;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicoPetResponseDTO {
    Long id;
    String nome;
    List<VarianteServico> variantes;

    public ServicoPetResponseDTO(Servico servico){
        ModelMapperUtil.map(servico, this);
    }
}
