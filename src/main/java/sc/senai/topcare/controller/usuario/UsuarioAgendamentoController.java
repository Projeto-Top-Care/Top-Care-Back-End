package sc.senai.topcare.controller.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.agendamento.AgendamentoRequestDTO;
import sc.senai.topcare.controller.dto.agendamento.AgendamentoResponseDTO;
import sc.senai.topcare.service.agendamento.AgendamentoService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("usuario/agendamento")
@AllArgsConstructor
public class UsuarioAgendamentoController{

    private final AgendamentoService service;

    @PostMapping("/{id}")
    public ResponseEntity<Long> fazerAgendamento(@RequestBody AgendamentoRequestDTO dto,
                                                 @PathVariable Long id){
        return ResponseEntity.ok(service.criarAgendamento(dto, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponseDTO> buscarAgendamento(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> confirmarPagamento(@PathVariable Long id){
        service.confirmarPagamento(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAgendamento(@PathVariable Long id){
        service.excluirAgendamento(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cancelamento/{id}")
    public ResponseEntity<Boolean> podeExcluir(@PathVariable Long id){
        return ResponseEntity.ok(service.podeExcluir(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<AgendamentoResponseDTO>> buscarTodosAgendamentos(){
        return ResponseEntity.ok(service.buscarTodosAgendamentos());
    }
}
