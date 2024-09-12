package sc.senai.topcare.controller.dto.horarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Horario;

import java.util.List;

@NoArgsConstructor
@Data
public class FuncionarioHorarioDTO {
    Long id;
    String nome;
    List<HorarioResponseDTO> horarios;

    public FuncionarioHorarioDTO(Long id, String nome, List<Horario> horarios) {
        this.id = id;
        this.nome = nome;
        this.horarios = horarios.stream().map(HorarioResponseDTO::new).toList();
    }
}
