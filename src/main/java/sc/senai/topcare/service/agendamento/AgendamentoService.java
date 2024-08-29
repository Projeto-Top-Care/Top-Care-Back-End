package sc.senai.topcare.service.agendamento;

import sc.senai.topcare.controller.dto.agendamento.AgendamentoRequestDTO;
import sc.senai.topcare.entity.Agendamento;

public interface AgendamentoService {

    Boolean criarAgendamento(AgendamentoRequestDTO dto, Long id);

}
