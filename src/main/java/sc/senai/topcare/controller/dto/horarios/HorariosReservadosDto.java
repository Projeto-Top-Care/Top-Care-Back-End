package sc.senai.topcare.controller.dto.horarios;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Data
public class HorariosReservadosDto {

    String servico;
    LocalDate data;
    LocalTime hora;
    String nomePet;
    String animal;
    String raca;
    String porte;

}
