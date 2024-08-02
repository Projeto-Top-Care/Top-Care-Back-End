package sc.senai.topcare.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.controller.dto.usuario.ClienteRequestPostDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.service.implement.ProdutoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoServiceImpl produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodosProdutos() {
        List<Produto> produtos = produtoService.buscarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(produtoService.buscarProdutoPorId(id), HttpStatus.OK);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Produto> cadastroProduto(@RequestBody ProdutoRequestDTO produtoDTO) {
        return produtoService.cadastroProduto(produtoDTO);
    }



}
