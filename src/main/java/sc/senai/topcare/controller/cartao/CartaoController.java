package sc.senai.topcare.controller.cartao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.cartao.CartaoRequestDTO;
import sc.senai.topcare.service.cartao.CartaoServiceImpl;

@RestController
@RequestMapping("/cartoes")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CartaoController {

    private final CartaoServiceImpl service;

    @PostMapping("/{id}")
    public ResponseEntity<?> criarCartao(@RequestBody CartaoRequestDTO dto, @PathVariable Long id){
        service.criarCartao(dto, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
