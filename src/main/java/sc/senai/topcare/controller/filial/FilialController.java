package sc.senai.topcare.controller.filial;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.filial.FilialCompletaResponseDto;
import sc.senai.topcare.controller.dto.filial.FilialPostDto;
import sc.senai.topcare.controller.dto.filial.FilialSimplesRequestDTO;
import sc.senai.topcare.entity.Filial;
import sc.senai.topcare.service.filial.FilialServiceImpl;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/filiais")
public class FilialController {
    private final FilialServiceImpl filialService;

    @PostMapping
    public ResponseEntity<Boolean> cadastro(@Valid @RequestBody FilialPostDto filialPostDto) {
        return new ResponseEntity<>(filialService.cadastro(filialPostDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filial> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(filialService.buscarFiliar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FilialSimplesRequestDTO>> listarFiliais() {
        return new ResponseEntity<>(filialService.buscarFiliais(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FilialSimplesRequestDTO> atualizarNome(@PathVariable Long id, @RequestBody FilialSimplesRequestDTO filial) {
        return new ResponseEntity<>(filialService.atualizar(id, filial), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> remover(@PathVariable Long id) {
        return new ResponseEntity<>(filialService.excluir(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> editar(@PathVariable Long id, @RequestBody FilialCompletaResponseDto filialDto) {
        return new ResponseEntity<>(filialService.editarFilial(id, filialDto), HttpStatus.OK);
    }
}
