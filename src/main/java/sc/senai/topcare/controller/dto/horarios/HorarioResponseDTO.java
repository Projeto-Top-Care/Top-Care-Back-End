package sc.senai.topcare.controller.dto.horarios;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Horario;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HorarioResponseDTO {
    LocalTime horaInicio;
    LocalTime horaFim;

    public HorarioResponseDTO(Horario horario) {
        ModelMapperUtil.map(horario, this);
    }
}
