package sc.senai.topcare.controller.quantidadeProduto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoPatchDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestSimplesDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoResponseSimplesDTO;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.service.quantidadeProduto.QuantidadeProdutoServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/quantidadeProduto")
public class QuantidadeProdutoController {

    private final QuantidadeProdutoServiceImpl service;

    @PostMapping
    public ResponseEntity<QuantidadeProduto> cadastrarQuantProduto(@RequestBody QuantidadeProdutoRequestDTO dto) {
        return new ResponseEntity<>(service.criarQuantProduto(dto), HttpStatusCode.valueOf(201));
    }

    @PostMapping("/basico")
    public ResponseEntity<QuantidadeProduto> cadastrarQuantProdutoBasico(@RequestBody QuantidadeProdutoRequestDTO dto) {
        return new ResponseEntity<>(service.criarQuantProduto(dto), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuantidadeProduto> buscarPorId(@PathVariable Long id) {
        QuantidadeProduto quantidadeProduto = service.buscarPorId(id);
        return new ResponseEntity<>(quantidadeProduto, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<QuantidadeProdutoResponseSimplesDTO> buscarPorIdSimples(@PathVariable Long id) {
        QuantidadeProduto quantidadeProduto = service.buscarPorId(id);
        return new ResponseEntity<>(quantidadeProduto.paraSimplesResponseDTO(), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<QuantidadeProduto>> buscarTodos() {
        try{
            List<QuantidadeProduto> quantidadeProdutos = service.buscarTodos();
            return ResponseEntity.ok(quantidadeProdutos);
        } catch (ListaVaziaException e){
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/produto")
    public ResponseEntity<List<QuantidadeProdutoResponseSimplesDTO>> buscarTodosSimples() {
        try{
            List<QuantidadeProdutoResponseSimplesDTO> quantidadeProdutos = service.buscarTodosSimples();
            return ResponseEntity.ok(quantidadeProdutos);
        } catch (ListaVaziaException e){
            return ResponseEntity.status(204).build();
        }
    }

    @PatchMapping("/adicionar/{id}")
    public ResponseEntity<Integer> adicionarQuantidade(@PathVariable Long id) {
        return ResponseEntity.ok(service.adicionarQuantidade(id));
    }

    @PatchMapping("/remover/{id}")
    public ResponseEntity<Integer> removerQuantidade(@PathVariable Long id) {
        return ResponseEntity.ok(service.removerQuantidade(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletar(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletarQuantidadeProduto(id), HttpStatus.OK);
    }
}
