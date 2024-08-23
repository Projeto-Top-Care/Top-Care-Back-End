package sc.senai.topcare.service.carrinho;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.Carrinho;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.repository.CarrinhoRepository;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl {

    private final CarrinhoRepository repository;


    public void adicionarProduto(Long id, QuantidadeProduto quantidadeProduto) {

    }


}
