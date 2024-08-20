package sc.senai.topcare.controller.quantidadeProduto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestSimplesDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoResponseSimplesDTO;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.service.quantidadeProduto.QuantidadeProdutoServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quantidadeProduto")
public class QuantidadeProdutoController {

    private final QuantidadeProdutoServiceImpl service;

    @PostMapping
    public ResponseEntity<QuantidadeProduto> cadastrar(@RequestBody QuantidadeProdutoRequestDTO dto) {
        return service.criarQuantProduto(dto);
    }

    @PostMapping("/produto")
    public ResponseEntity<QuantidadeProduto> cadastrarSimples(@RequestBody QuantidadeProdutoRequestSimplesDTO dto) {
        return service.criarQuantProdutoSimples(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuantidadeProduto> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<QuantidadeProdutoResponseSimplesDTO> buscarPorIdSimples(@PathVariable Long id) {
        return service.buscarPorIdSimples(id);
    }

    @GetMapping
    public ResponseEntity<List<QuantidadeProduto>> buscarTodos() {
        return service.buscarTodos();
    }

    @GetMapping("/produto")
    public ResponseEntity<List<QuantidadeProdutoResponseSimplesDTO>> buscarTodosSimples() {
        return service.buscarTodosSimples();
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuantidadeProduto> atualizar(@PathVariable Long id, @RequestBody QuantidadeProdutoRequestDTO dto) {
        return service.atualizar(id, dto);
    }
}
