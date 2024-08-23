package sc.senai.topcare.controller.dto.servicos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoResponseDTO {
    Long id;
    String imagem;
    String nome;
    String categoria;
    String descricao;
    List<FuncionarioResponseDTO> funcionarios;
    List<FuncionarioResponseDTO> especies;
    List<VarianteResponseDTO> variantes;

    public ServicoResponseDTO(Servico servico) {
        ModelMapperUtil.map(servico, this);
        this.funcionarios = servico.getFuncionarios().stream().map(FuncionarioResponseDTO::new).toList();
        this.especies = servico.getEspecies().stream().map(FuncionarioResponseDTO::new).toList();
        this.variantes = servico.getVariantes().stream().map(VarianteResponseDTO::new).toList();
    }

}
