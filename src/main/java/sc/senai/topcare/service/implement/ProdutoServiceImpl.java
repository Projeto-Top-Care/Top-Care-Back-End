package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl {

    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) throws Exception {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("produto não encontrado");
        }
    }
}
