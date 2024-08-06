package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.AgendamentoPostDto;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.facade.PostFacade;
import sc.senai.topcare.repository.AgendamentoRepository;
import sc.senai.topcare.service.interfaces.AgendamentoService;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final PostFacade postFacade = null;

    @Override
    public Agendamento novoAgendamento(AgendamentoPostDto agendamentoPostDto) {
        try {
            //cliente.getAgendamentos().add(novoAgendamento);
            Agendamento agendamento = postFacade.postAgendamento(agendamentoPostDto);
            agendamento.getCliente().getAgendamentos().add(agendamento);
            return agendamentoRepository.save(agendamento);

        } catch (RuntimeException e) {
            System.out.println((e.getMessage()));
        }
        return null;
    }
}
