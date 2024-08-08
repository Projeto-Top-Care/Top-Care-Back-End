package sc.senai.topcare.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.entity.ProdutoEx;
import sc.senai.topcare.service.implement.ProdutoExImpl;

import java.util.List;

@RestController
@RequestMapping("/produtoEx")
@AllArgsConstructor
public class ProdutoExController {

    private ProdutoExImpl produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEx> buscarProdutoPorId(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(produtoService.buscarProdutoExPorId(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/preco")
    public ResponseEntity<Double> buscarPreco(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(produtoService.getPreco(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ProdutoEx>> buscarTodosProdutos() {
        List<ProdutoEx> produtos = produtoService.buscarProdutosEx();
        return ResponseEntity.ok(produtos);
    }
    @PostMapping("/cadastro")
    public ResponseEntity<ProdutoEx> cadastroProdutoEx(@RequestBody ProdutoEx produtoEx) {
        return new ResponseEntity<>(produtoService.salvarProduto(produtoEx), HttpStatus.OK);
    }
}
