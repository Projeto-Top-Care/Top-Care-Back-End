package sc.senai.topcare.service.produto;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.produto.PaginaProdutos;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.exceptions.ProdutoNaoEncontradoException;

@Service
public interface ProdutoService {

    void cadastroProduto(ProdutoRequestDTO produtoDTO);
    String deletarProduto(Long id) throws ProdutoNaoEncontradoException;
    PaginaProdutos buscarTodosProdutos(Pageable pageable);
    Produto buscarProdutoPorId(Long id) throws Exception;
    Produto buscar(Long id);
    Produto atualizarProduto(Long id, ProdutoRequestDTO produtoRequestDTO);
}
