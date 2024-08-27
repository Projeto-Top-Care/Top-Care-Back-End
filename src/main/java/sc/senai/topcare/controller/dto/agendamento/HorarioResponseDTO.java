package sc.senai.topcare.controller.dto.agendamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Horario;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HorarioResponseDTO {
    Long id;
    LocalDate dia;
    LocalTime horaInicio;
    String funcionario;

    public HorarioResponseDTO(Horario horario) {
        this.id = horario.getId();
        this.dia = horario.getDia();
        this.horaInicio = horario.getHoraInicio();
        this.funcionario = horario.getFuncionario().getNome();
    }
}

