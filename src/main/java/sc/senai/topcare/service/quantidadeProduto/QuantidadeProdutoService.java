package sc.senai.topcare.service.quantidadeProduto;

import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoPatchDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestSimplesDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoResponseSimplesDTO;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.exceptions.ListaVaziaException;

import java.util.List;

public interface QuantidadeProdutoService {
    QuantidadeProduto criarQuantProduto(QuantidadeProdutoRequestDTO dto);

    QuantidadeProduto criarQuantProdutoSimples(QuantidadeProdutoRequestSimplesDTO dto);

    QuantidadeProduto buscarPorId(Long id);

    List<QuantidadeProduto> buscarTodos() throws ListaVaziaException;

    List<QuantidadeProdutoResponseSimplesDTO> buscarTodosSimples() throws ListaVaziaException;

    QuantidadeProduto editarQuantProduto(Long id, QuantidadeProdutoPatchDTO dto);

    Boolean deletarQuantidadeProduto(Long id);
}
