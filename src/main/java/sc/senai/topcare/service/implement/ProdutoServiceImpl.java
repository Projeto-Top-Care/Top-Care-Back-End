package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.repository.ProdutoRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ProdutoServiceImpl {

    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {

        return null;
    }
}
