package sc.senai.topcare.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.entity.CarrinhoEx;
import sc.senai.topcare.service.implement.CarrinhoExImpl;

import java.util.List;

@RestController
@RequestMapping("/carrinhoEx")
@AllArgsConstructor
public class CarrinhoExController {

    private CarrinhoExImpl carrinhoService;
    @GetMapping("/{id}/preco")
    public ResponseEntity<Double> buscarPreco(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(carrinhoService.getPreco(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<CarrinhoEx>> buscarTodosProdutosEx() {
        List<CarrinhoEx> carrinhosEx = carrinhoService.buscarTodosCarrinhosEx();
        return ResponseEntity.ok(carrinhosEx);
    }
    @PostMapping("/cadastro")
    public ResponseEntity<CarrinhoEx> cadastroProdutoEx(@RequestBody CarrinhoEx carrinhoEx) {
        return new ResponseEntity<>(carrinhoService.salvarCarrinhoEx(carrinhoEx), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoEx> buscarProdutoExPorId(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(carrinhoService.buscarCarrinhoExPorId(id), HttpStatus.OK);
    }
}
