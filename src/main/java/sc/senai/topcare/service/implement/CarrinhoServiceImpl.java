package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.CarrinhoRequestPostDTO;
import sc.senai.topcare.entity.Carrinho;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.repository.CarrinhoRepository;
import sc.senai.topcare.service.interfaces.ProdutoComponent;

@Service
@AllArgsConstructor
public class CarrinhoServiceImpl {

    private final CarrinhoRepository carrinhoRepository;



    public void adicionar(CarrinhoRequestPostDTO carrinhoDto, QuantidadeProduto quantidadeProduto) {
        carrinhoDto.produtos().add(quantidadeProduto);
    }


    public void remover(CarrinhoRequestPostDTO carrinhoDto, QuantidadeProduto quantidadeProduto) {
        carrinhoDto.produtos().remove(quantidadeProduto);
    }


    public String getNome() {
        return "Carrinho de Compras";
    }


}
