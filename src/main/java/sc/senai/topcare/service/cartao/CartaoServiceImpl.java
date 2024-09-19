package sc.senai.topcare.service.cartao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.cartao.CartaoRequestDTO;
import sc.senai.topcare.entity.Cartao;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.repository.CartaoRepository;
import sc.senai.topcare.service.cliente.ClienteService;

@Service
@AllArgsConstructor
public class CartaoServiceImpl {

    private CartaoRepository repository;
    private ClienteService clienteService;

    public void criarCartao(CartaoRequestDTO dto, Long id) {
        Cliente cliente = clienteService.buscarCliente(id);
        Cartao cartao = new Cartao(dto);
        cliente.getCartoes().add(cartao);
        clienteService.salvar(cliente);
    }
}
