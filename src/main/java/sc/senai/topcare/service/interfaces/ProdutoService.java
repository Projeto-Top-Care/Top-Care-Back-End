package sc.senai.topcare.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.exceptions.ProdutoNaoEncontradoException;

import java.util.List;

@Service
public interface ProdutoService {

    ResponseEntity<Produto> cadastroProduto(ProdutoRequestDTO produtoDTO);
    String deletarProduto(Long id) throws ProdutoNaoEncontradoException;
    List<Produto> buscarTodosProdutos();
    Produto buscarProdutoPorId(Long id) throws Exception;
    Produto buscar(Long id);

    Produto atualizarProduto(Long id, ProdutoRequestDTO produtoRequestDTO);
}
