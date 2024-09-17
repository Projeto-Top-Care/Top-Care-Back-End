package sc.senai.topcare.service.carrinho;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestDTO;
import sc.senai.topcare.entity.Carrinho;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.repository.CarrinhoRepository;
import sc.senai.topcare.service.quantidadeProduto.QuantidadeProdutoServiceImpl;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl {

    private final CarrinhoRepository carrinhoRepository;
    private final QuantidadeProdutoServiceImpl quantidadeProdutoService;

    public void criarCarrinhoSimples(Long id){
        Carrinho carrinho = new Carrinho();
        carrinho.setUsuario(new Cliente(id));
        carrinhoRepository.save(carrinho);
    }

    public Carrinho buscarPorId(Long id) {
        try {
            return carrinhoRepository.findById(id).orElseThrow(RuntimeException::new);
        } catch (Exception e) {
            return null;
        }
    }

    public Carrinho buscarPorUsuarioId(Long id) {
        return carrinhoRepository.findByUsuarioId(id);
    }

    public void adicionarProduto(Long id, QuantidadeProdutoRequestDTO quantidadeProduto) {
        Carrinho carrinho = buscarPorUsuarioId(id);
        QuantidadeProduto quantidadeProduto1 = quantidadeProdutoService.criarQuantProduto(quantidadeProduto);
        carrinho.getProdutos().add(quantidadeProduto1);
        carrinhoRepository.save(carrinho);
    }

    public void removerProduto(Long id, QuantidadeProduto quantidadeProduto) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElseThrow(RuntimeException::new);
        carrinho.getProdutos().remove(quantidadeProduto);
        carrinhoRepository.save(carrinho);
    }

    public Carrinho adicionarDesconto(Long id, Double desconto) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElseThrow(RuntimeException::new);
        carrinho.setDesconto(desconto);
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho adicionarFrete(Long id, Double frete) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElseThrow(RuntimeException::new);
        carrinho.setFrete(frete);
        return carrinhoRepository.save(carrinho);
    }
}
