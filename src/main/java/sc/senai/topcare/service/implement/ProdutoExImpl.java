package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.CarrinhoEx;
import sc.senai.topcare.entity.ProdutoEx;
import sc.senai.topcare.repository.ProdutoExRepository;
import sc.senai.topcare.service.interfaces.CarrinhoComponent;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoExImpl  {

    private ProdutoExRepository produtoExRepository;

    public ProdutoEx salvarProduto(ProdutoEx produto){
        return produtoExRepository.save(produto);
    }
    public double getPreco(Long id) throws Exception {
        ProdutoEx produto = buscarProdutoExPorId(id);
        return produto.getPreco() ;
    }

    public ProdutoEx buscarProdutoExPorId(Long id) throws Exception {
        Optional<ProdutoEx> optional =  produtoExRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Produto não encontrado!");
        }
    }
    public List<ProdutoEx> buscarProdutosEx(){
        return produtoExRepository.findAll();
    }

    public ProdutoEx atualizarProduto(Long id, ProdutoEx produto) {
        produto.setId(id);
        return salvarProduto(produto);
    }
    public void removerProduto(Long id) {
        if(!produtoExRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado!");
        }
        produtoExRepository.deleteById(id);
        if (produtoExRepository.existsById(id)){
            throw new RuntimeException("Não foi possível deletar o produto de Id " + id);
        }
    }



}
