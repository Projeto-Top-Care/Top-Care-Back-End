package sc.senai.topcare.service.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.pedido.PedidoRequestDTO;
import sc.senai.topcare.controller.dto.pedido.PedidoResponseDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoResponseSimplesDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final PagamentoRepository pagamentoRepository;
    private final EnderecoRepository enderecoRepository;
    private final QuantidadeProdutoRepository quantidadeProdutoRepository;

    public Pedido criarPedido(PedidoRequestDTO dto) throws ListaVaziaException {
        Pedido pedido = new Pedido();
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(RuntimeException::new);
        Pagamento pagamento = pagamentoRepository.findById(dto.getPagamentoId()).orElseThrow(RuntimeException::new);
        Endereco endereco = enderecoRepository.findById(dto.getEnderecoId()).orElseThrow(RuntimeException::new);
        List<QuantidadeProduto> produtos = quantidadeProdutoRepository.findAllById(dto.getProdutosId());
        pedido.setProdutos(produtos);
        pedido.setCliente(cliente);
        pedido.setPagamento(pagamento);
        pedido.setEndereco(endereco);
        pedido.setCodigo(dto.getCodigo());
        pedido.setFrete(dto.getFrete());
        pedido.setDesconto(dto.getDesconto());
        pedido.setSubTotal(dto.getSubTotal());
        pedido.setTotal(dto.getTotal());
        pedido.setDataCompra(LocalDateTime.now());
        pedido.setStatus(StatusPedido.CRIADO);
        return repository.save(pedido);
    }

    @Override
    public PedidoResponseDTO buscarPorId(Long id) {
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isEmpty()){
            throw new RuntimeException("O Pedido não existe");
        }
        return new PedidoResponseDTO(pedido.get());
    }

    @Override
    public List<PedidoResponseDTO> buscarTodos() throws ListaVaziaException {
        List<PedidoResponseDTO> pedidos = repository
                .findAll()
                .stream()
                .map(PedidoResponseDTO::new)
                .toList();
        if(pedidos.isEmpty()){
            throw new ListaVaziaException();
        }
        return pedidos;
    }

    @Override
    public Boolean editar(PedidoRequestDTO dto, Long id) {
        Pedido pedido = repository.findById(id).orElseThrow(RuntimeException::new);
        pedido.editar(dto);
        repository.save(pedido);
        return true;
    }

    @Override
    public Boolean deletar(Long id) {
        repository.deleteById(id);
        return null;
    }
}
