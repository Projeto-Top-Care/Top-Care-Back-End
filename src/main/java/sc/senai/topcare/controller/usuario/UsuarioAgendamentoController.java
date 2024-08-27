package sc.senai.topcare.controller.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.agendamento.AgendamentoRequestDTO;
import sc.senai.topcare.service.agendamento.AgendamentoService;

@RestController
@CrossOrigin("*")
@RequestMapping("usuario/agendamento")
@AllArgsConstructor
public class UsuarioAgendamentoController{

    private final AgendamentoService service;

    @PostMapping("/{id}")
    public ResponseEntity<Boolean> fazerAgendamento(@RequestBody AgendamentoRequestDTO dto,
                                                    @PathVariable Long id){
        return ResponseEntity.ok(service.criarAgendamento(dto, id));
    }
}
