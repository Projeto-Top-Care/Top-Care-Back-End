package sc.senai.topcare.controller.servicos;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;
import sc.senai.topcare.controller.dto.servicos.ServicoResponseDTO;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.service.servico.ServicoService;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController {

    @Qualifier("servicoService")
    private final ServicoService service;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody ServicoRequestDTO dto){
        service.cadastrar(dto);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> buscarUm(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> listar(){
        try {
            return ResponseEntity.ok(service.buscarTodos());
        } catch (ListaVaziaException e) {
            return ResponseEntity.noContent().build();
        }
    }

}
