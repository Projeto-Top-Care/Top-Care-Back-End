package sc.senai.topcare.service.pedido;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.pedido.PedidoRequestDTO;
import sc.senai.topcare.controller.dto.pedido.PedidoResponseDTO;
import sc.senai.topcare.exceptions.ListaVaziaException;

import java.util.List;

@Service
public interface PedidoService {

    void criarPedido(PedidoRequestDTO dto);

    PedidoResponseDTO buscarPorId(Long id);

    List<PedidoResponseDTO> buscarTodos() throws ListaVaziaException;

    Boolean editar(PedidoRequestDTO dto, Long id);

    Boolean deletar(Long id);
}
