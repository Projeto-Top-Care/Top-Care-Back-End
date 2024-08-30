package sc.senai.topcare.controller.dto.agendamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import sc.senai.topcare.controller.dto.usuario.response.pet.PetResponseDTO;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Data
public class AgendamentoSimplesDto {

    Long id;
    String nomeServico;
    PetResponseDTO pet;
    LocalTime hora;
    LocalDate data;

}
