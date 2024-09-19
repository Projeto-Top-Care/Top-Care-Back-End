package sc.senai.topcare.controller.servicos;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.controller.dto.horarios.FuncionarioHorarioDTO;
import sc.senai.topcare.controller.dto.horarios.HorarioResponseDTO;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;
import sc.senai.topcare.controller.dto.servicos.ServicoResponseDTO;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.service.servico.ServicoService;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController {

    @Qualifier("servicoService")
    private final ServicoService service;

    @PostMapping(consumes = {"application/json", "multipart/form-data"})
    public ResponseEntity<Void> cadastrar(@RequestPart ServicoRequestDTO dto, @RequestPart MultipartFile imagem){
        service.cadastrar(dto, imagem);
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

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody ServicoRequestDTO dto, @PathVariable Long id){
        service.editar(dto, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/{dia}")
    public ResponseEntity<List<FuncionarioHorarioDTO>> buscarHorarios(@PathVariable Long id,
                                                                      @PathVariable LocalDate dia){
        return ResponseEntity.ok(service.buscarHorariosPorServico(id, dia));
    }

}
