package sc.senai.topcare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.topcare.controller.dto.usuario.request.AgendamentoPostDto;
import sc.senai.topcare.entity.Agendamento;
import sc.senai.topcare.service.implement.AgendamentoServiceImpl;

@RestController
@RequestMapping("usuario/agendamento")
public class AgendamentoController {

    private final AgendamentoServiceImpl agendamentoService;

    public AgendamentoController(AgendamentoServiceImpl agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping("/agendar")
    public ResponseEntity<Agendamento> agendamento (@RequestBody AgendamentoPostDto agendamentoPostDto) {
        return ResponseEntity.ok(agendamentoService.novoAgendamento(agendamentoPostDto));
    }
}
