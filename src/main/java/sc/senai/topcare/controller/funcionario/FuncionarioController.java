package sc.senai.topcare.controller.funcionario;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioPostDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioRequestPutDto;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioSimplesResponseDto;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.service.funcionario.FuncionarioService;
import sc.senai.topcare.service.funcionario.FuncionarioServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin("*")
@AllArgsConstructor
public class FuncionarioController {

    private FuncionarioServiceImpl service;

    @PostMapping
    public ResponseEntity<Boolean> cadastro(@RequestBody FuncionarioPostDto dto) {
        return new ResponseEntity<>(service.cadastro(dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarFuncionario(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioSimplesResponseDto>> buscarTodos(){
        try{
            return ResponseEntity.ok(service.buscarTodos());
        }catch(ListaVaziaException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioRequestPutDto> editarFuncionario(@PathVariable Long id, @RequestBody FuncionarioRequestPutDto dto) {
        return new ResponseEntity<>(service.editarFuncionario(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> remover(@PathVariable Long id) {
        return new ResponseEntity<>(service.excluir(id), HttpStatus.OK);
    }
}
