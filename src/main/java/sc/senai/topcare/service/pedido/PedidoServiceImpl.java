package sc.senai.topcare.service.pedido;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.pedido.PedidoRequestDTO;
import sc.senai.topcare.controller.dto.pedido.PedidoResponseDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.enuns.StatusPedido;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.*;
import sc.senai.topcare.service.cliente.ClienteServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;
    private final ClienteServiceImpl clienteService;

    public Pedido criarPedido(PedidoRequestDTO dto, Long id) throws ListaVaziaException {
        Pedido pedido = new Pedido(dto);
        Cliente cliente = clienteService.buscarCliente(id);
        cliente.getPedidos().add(pedido);
        pedido.setCliente(cliente);
        clienteService.salvar(cliente);
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
    public Boolean editarStatus(String status, Long id) {
        Optional<Pedido> pedido = repository.findById(id);
        if(pedido.isEmpty()){
            throw new RuntimeException("O Pedido não existe");
        }
        pedido.get().setStatus(StatusPedido.valueOf(status));
        repository.save(pedido.get());
        return null;
    }

    @Override
    public Boolean deletar(Long id) {
        repository.deleteById(id);
        return null;
    }
}
