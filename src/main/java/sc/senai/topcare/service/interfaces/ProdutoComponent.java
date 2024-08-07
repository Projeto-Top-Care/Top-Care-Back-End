package sc.senai.topcare.service.interfaces;

import sc.senai.topcare.controller.dto.usuario.request.CarrinhoRequestPostDTO;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.entity.QuantidadeProduto;

public interface ProdutoComponent {

    void adicionar(CarrinhoRequestPostDTO carrinhoDto, QuantidadeProduto quantidadeProduto);
    void remover(CarrinhoRequestPostDTO carrinhoDto, QuantidadeProduto quantidadeProduto);
    Produto getFilho(int i);
    String getNome();
    Double getPreco();
    void exibir();

}
