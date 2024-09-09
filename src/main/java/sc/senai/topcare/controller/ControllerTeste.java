package sc.senai.topcare.controller;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.entity.Filial;
import sc.senai.topcare.entity.Horario;
import sc.senai.topcare.entity.Imagem;
import sc.senai.topcare.repository.FilialRepository;
import sc.senai.topcare.service.horario.HorarioService;
import sc.senai.topcare.service.imagem.ImagemService;

@RestController
@CrossOrigin("*")
@RequestMapping("/teste")
@AllArgsConstructor
public class ControllerTeste {

    private HorarioService horarioService;
    private FilialRepository filialRepository;
    private ImagemService imagemService;

    @GetMapping("/horarios/{data}/{id}")
    public List<Horario> getHorarios(@PathVariable LocalDate data, @PathVariable Long id) {
        return horarioService.buscarPorDiaELivre(data, id);
    }
    @GetMapping("/filiais")
    public List<Filial> getFilials() {
        return filialRepository.findAll();
    }

    @PostMapping("/imagem")
    public ResponseEntity<Imagem> salvarImagem(@RequestBody MultipartFile multipartFile) {

        return ResponseEntity.ok(imagemService.salvarImagem(multipartFile));
    }

}
