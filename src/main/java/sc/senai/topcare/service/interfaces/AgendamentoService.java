package sc.senai.topcare.service.interfaces;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.AgendamentoPostDto;
import sc.senai.topcare.entity.*;

import java.time.LocalDateTime;

@Service
public interface AgendamentoService {
    Agendamento novoAgendamento(AgendamentoPostDto agendamentoPostDto);

}
