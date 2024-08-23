package sc.senai.topcare.service.quantidadeProduto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoPatchDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestSimplesDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoResponseSimplesDTO;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.QuantidadeProdutoRepository;
import sc.senai.topcare.service.implement.ProdutoServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuantidadeProdutoServiceImpl implements QuantidadeProdutoService {

    private final QuantidadeProdutoRepository repository;
    private final ProdutoServiceImpl produtoService;

    @Override
    public QuantidadeProduto criarQuantProduto(QuantidadeProdutoRequestDTO dto) {
        QuantidadeProduto quantidadeProduto = new QuantidadeProduto();
        quantidadeProduto.setProduto(dto.getProduto());
        quantidadeProduto.setQuantidade(dto.getQuantidade());
        return repository.save(quantidadeProduto);
    }

    @Override
    public QuantidadeProduto criarQuantProdutoSimples(QuantidadeProdutoRequestSimplesDTO dto) {
        QuantidadeProduto quantidadeProduto = new QuantidadeProduto();
        quantidadeProduto.setProduto(produtoService.buscar(dto.getProdutoId()));
        quantidadeProduto.setQuantidade(dto.getQuantidade());
        return repository.save(quantidadeProduto);
    }

    @Override
    public QuantidadeProduto buscarPorId(Long id) {
        Optional<QuantidadeProduto> quantidadeOptional = repository.findById(id);
        if(quantidadeOptional.isEmpty()){
            throw new RuntimeException("A quantidade não foi encontrada");
        }
        return quantidadeOptional.get();
    }

    @Override
    public List<QuantidadeProduto> buscarTodos() throws ListaVaziaException {
        List<QuantidadeProduto> quantidadeProdutos = repository.findAll();
        if (quantidadeProdutos.isEmpty()){
           throw new ListaVaziaException();
        }
        return quantidadeProdutos;
    }

    @Override
    public List<QuantidadeProdutoResponseSimplesDTO> buscarTodosSimples() throws ListaVaziaException {
        List<QuantidadeProduto> quantidadeProdutos = buscarTodos();
        List<QuantidadeProdutoResponseSimplesDTO> quantidadeDTO = new ArrayList<>();
        for(QuantidadeProduto quantidade: quantidadeProdutos){
            quantidadeDTO.add(quantidade.paraSimplesResponseDTO());
        }
        return quantidadeDTO;
    }

    @Override
    public QuantidadeProduto editarQuantProduto(Long id, QuantidadeProdutoPatchDTO dto) {
        QuantidadeProduto quantidadeProduto = buscarPorId(id);
        quantidadeProduto.setQuantidade(dto.getQuantidade());
        return repository.save(quantidadeProduto);
    }

    @Override
    public Boolean deletarQuantidadeProduto(Long id){
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
