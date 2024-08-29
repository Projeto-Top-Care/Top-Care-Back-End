package sc.senai.topcare.controller;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.*;

import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.entity.Filial;
import sc.senai.topcare.entity.Horario;
import sc.senai.topcare.repository.FilialRepository;
import sc.senai.topcare.service.horario.HorarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/teste")
@AllArgsConstructor
public class ControllerTeste {

    private HorarioService horarioService;
    private FilialRepository filialRepository;

    @GetMapping("/horarios/{data}/{id}")
    public List<Horario> getHorarios(@PathVariable LocalDate data, @PathVariable Long id) {
        return horarioService.buscarPorDiaELivre(data, id);
    }
    @GetMapping("/filiais")
    public List<Filial> getFilials() {
        return filialRepository.findAll();
    }
}
