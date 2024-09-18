package sc.senai.topcare.service.agendamento;

import sc.senai.topcare.controller.dto.agendamento.AgendamentoRequestDTO;
import sc.senai.topcare.controller.dto.agendamento.AgendamentoResponseDTO;
import sc.senai.topcare.entity.Agendamento;

import java.util.List;

public interface AgendamentoService {

    Long criarAgendamento(AgendamentoRequestDTO dto, Long id);

    AgendamentoResponseDTO buscarPorId(Long id);

    List<AgendamentoResponseDTO> buscarTodosAgendamentos();

    void confirmarPagamento(Long id);

    void excluirAgendamento(Long id);

    Boolean podeExcluir(Long id);
}
