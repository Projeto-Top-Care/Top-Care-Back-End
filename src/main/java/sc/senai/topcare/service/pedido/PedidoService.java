package sc.senai.topcare.service.pedido;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.pedido.PedidoRequestDTO;
import sc.senai.topcare.controller.dto.pedido.PedidoResponseDTO;
import sc.senai.topcare.entity.Pedido;
import sc.senai.topcare.enuns.StatusPedido;
import sc.senai.topcare.exceptions.ListaVaziaException;

import java.util.List;

@Service
public interface PedidoService {

    Pedido criarPedido(PedidoRequestDTO dto, Long id) throws ListaVaziaException;

    PedidoResponseDTO buscarPorId(Long id);

    List<PedidoResponseDTO> buscarTodos() throws ListaVaziaException;


    Boolean editarStatus(String status, Long id);

    Boolean deletar(Long id);
}
