package sc.senai.topcare.service.carrinho;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.carrinho.CarrinhoRequestBasicoDTO;
import sc.senai.topcare.controller.dto.carrinho.CarrinhoRequestDTO;
import sc.senai.topcare.entity.Carrinho;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.repository.CarrinhoRepository;
import sc.senai.topcare.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl {

    private final CarrinhoRepository carrinhoRepository;
    private final UsuarioRepository usuarioRepository;

    public Carrinho criarCarrinho(CarrinhoRequestDTO dto){
        Carrinho carrinho = new Carrinho();
        carrinho.setUsuario(usuarioRepository.findById(dto.usuarioId).orElseThrow(RuntimeException::new));
        carrinho.setProdutos(dto.produtos);
        carrinho.setSubTotal(dto.subTotal);
        carrinho.setTotal(dto.total);
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho criarCarrinhoSimples(CarrinhoRequestBasicoDTO dto){
        Carrinho carrinho = new Carrinho();
        carrinho.setUsuario(usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(RuntimeException::new));
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho buscarPorId(Long id) {
        return carrinhoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void adicionarProduto(Long id, QuantidadeProduto quantidadeProduto) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElseThrow(RuntimeException::new);
        carrinho.getProdutos().add(quantidadeProduto);
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

    public Boolean deletarCarrinho(Long id) {
        try {
            carrinhoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
