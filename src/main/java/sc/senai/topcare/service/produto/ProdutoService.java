package sc.senai.topcare.service.produto;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.controller.dto.produto.PaginaProdutos;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.exceptions.ProdutoNaoEncontradoException;

import java.util.List;

@Service
public interface ProdutoService {

    void cadastroProduto(ProdutoRequestDTO produtoDTO, List<MultipartFile> files);
    String deletarProduto(Long id) throws ProdutoNaoEncontradoException;
    PaginaProdutos buscarTodosProdutos(Pageable pageable);
    Produto buscarProdutoPorId(Long id) throws Exception;
    Produto buscar(Long id);
    Produto atualizarProduto(Long id, ProdutoRequestDTO produtoRequestDTO);
}
