package sc.senai.topcare.service.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.pedido.PedidoRequestDTO;
import sc.senai.topcare.controller.dto.pedido.PedidoResponseDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.ClienteRepository;
import sc.senai.topcare.repository.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;



    public void criarPedido(PedidoRequestDTO dto) {
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente();
        clienteRepository.save(cliente);
        pedido.setCliente(cliente);
        pedido.setCodigo(dto.getCodigo());
        pedido.setDataCompra(dto.getDataCompra());
        pedido.setStatus(dto.getStatus());
        pedido.setFrete(dto.getFrete());
        pedido.setDesconto(dto.getDesconto());
        pedido.setSubTotal(dto.getSubTotal());
        pedido.setTotal(dto.getTotal());
        repository.save(pedido);
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
