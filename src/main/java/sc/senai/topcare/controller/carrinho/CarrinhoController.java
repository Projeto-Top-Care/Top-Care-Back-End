package sc.senai.topcare.controller.carrinho;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.carrinho.CarrinhoRequestDTO;
import sc.senai.topcare.controller.dto.carrinho.CarrinhoResponseDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestDTO;
import sc.senai.topcare.entity.Carrinho;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.service.carrinho.CarrinhoServiceImpl;

@RestController
@RequestMapping("/carrinho")
@CrossOrigin("*")
@AllArgsConstructor
public class CarrinhoController {

    private CarrinhoServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<CarrinhoResponseDTO> buscarPorId(@PathVariable Long id) {
        Carrinho carrinho = service.buscarPorId(id);
        if (carrinho == null) {
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(carrinho.paraResponseDTO(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<CarrinhoResponseDTO> buscarPorUsuarioId(@PathVariable Long id) {
        Carrinho carrinho = service.buscarPorUsuarioId(id);
        if (carrinho == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(carrinho.paraResponseDTO(), HttpStatusCode.valueOf(200));
    }

    @PatchMapping("/{id}/adicionar")
    public ResponseEntity<Void> adicionarProduto(@PathVariable Long id, @RequestBody QuantidadeProdutoRequestDTO produto) {
        service.adicionarProduto(id, produto);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
    @PatchMapping("/{id}/remover")
    public ResponseEntity<Void> removerProduto(@PathVariable Long id, @RequestBody QuantidadeProduto produto) {
        service.removerProduto(id, produto);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> limparCarrinho(@PathVariable Long id) {
        service.limparCarrinho(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
