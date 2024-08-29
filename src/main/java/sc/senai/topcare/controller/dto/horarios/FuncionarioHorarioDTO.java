package sc.senai.topcare.controller.dto.horarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Horario;

import java.util.List;

@NoArgsConstructor
@Data
public class FuncionarioHorarioDTO {
    String nome;
    List<HorarioResponseDTO> horarios;

    public FuncionarioHorarioDTO(String nome, List<Horario> horarios) {
        this.nome = nome;
        this.horarios = horarios.stream().map(HorarioResponseDTO::new).toList();
    }
}
