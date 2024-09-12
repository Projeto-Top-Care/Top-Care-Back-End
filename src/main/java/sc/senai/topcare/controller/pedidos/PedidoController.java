package sc.senai.topcare.controller.pedidos;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.pedido.PedidoRequestDTO;
import sc.senai.topcare.controller.dto.pedido.PedidoResponseDTO;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.service.pedido.PedidoService;

import java.util.List;


@RestController
@RequestMapping("/pedidos")
@CrossOrigin("*")
@AllArgsConstructor
public class PedidoController {

    @Qualifier("pedidoService")
    private PedidoService service;

    @PostMapping
    public ResponseEntity<Void> criarPedido(@RequestBody PedidoRequestDTO dto) throws ListaVaziaException {
        service.criarPedido(dto);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarUm(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listar(){
        try {
            return ResponseEntity.ok(service.buscarTodos());
        } catch (ListaVaziaException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody PedidoRequestDTO dto, @PathVariable Long id){
        service.editarStatus(dto.getStatus(), id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
