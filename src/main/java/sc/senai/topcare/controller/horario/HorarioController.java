package sc.senai.topcare.controller.horario;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.horarios.HorarioResponseDTO;
import sc.senai.topcare.service.horario.HorarioService;

import java.util.List;

@RestController
@RequestMapping("/horario")
@CrossOrigin("*")
@AllArgsConstructor
public class HorarioController {
    private HorarioService horarioService;

    @GetMapping("/{id}")
    public ResponseEntity<List<HorarioResponseDTO>> verHorariosDisponiveis(@PathVariable Long id) {
        return new ResponseEntity<>(horarioService.verHorariosDisponiveis(id), HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Boolean> reservarHorario(@PathVariable Long id) {
//        return new ResponseEntity<>(horarioService.agendarHorario(id), HttpStatus.OK);
//    }
}
