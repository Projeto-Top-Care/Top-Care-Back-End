package sc.senai.topcare.controller.produto;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.controller.dto.produto.PaginaProdutos;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestPutDTO;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.service.produto.ProdutoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoServiceImpl produtoService;

    @GetMapping
    public ResponseEntity<PaginaProdutos> buscarTodosProdutos(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok(produtoService.buscarTodosProdutos(pageable));
    }

    @GetMapping("/completo")
    public ResponseEntity<List<Produto>> buscarTodosCompleto(){
        return ResponseEntity.ok(produtoService.buscarTodosCompleto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(produtoService.buscarProdutoPorId(id), HttpStatus.OK);
    }

    @PostMapping(consumes = {"application/json", "multipart/form-data"})
    public ResponseEntity<Void> cadastroProduto(
            @RequestPart ProdutoRequestDTO produtoDTO,
            @RequestPart List<MultipartFile> files
            ) {
        produtoService.cadastroProduto(produtoDTO, files);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}", consumes = {"application/json", "multipart/form-data"})
    public Produto atualizarProduto(@PathVariable Long id,
                                    @RequestPart ProdutoRequestPutDTO produtoRequestDTO,
                                    @RequestPart(required = false) List<MultipartFile> files) {
        return produtoService.atualizarProduto(id, produtoRequestDTO, files);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProdutoPorId(@PathVariable Long id){
        return ResponseEntity.ok(produtoService.deletarProduto(id));
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<String>> buscarEspeciesDosProdutos(
            @RequestParam String query
    ){
        return ResponseEntity.ok(produtoService.buscarFiltros(query));
    }

}
