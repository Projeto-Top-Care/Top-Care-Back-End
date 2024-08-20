package sc.senai.topcare.service.quantidadeProduto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoRequestSimplesDTO;
import sc.senai.topcare.controller.dto.quantidadeProduto.QuantidadeProdutoResponseSimplesDTO;
import sc.senai.topcare.entity.QuantidadeProduto;
import sc.senai.topcare.repository.ProdutoRepository;
import sc.senai.topcare.repository.QuantidadeProdutoRepository;
import sc.senai.topcare.service.implement.ProdutoServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class QuantidadeProdutoServiceImpl {

    private final QuantidadeProdutoRepository repository;
    private final ProdutoServiceImpl produtoService;

    public ResponseEntity<QuantidadeProduto> criarQuantProduto(QuantidadeProdutoRequestDTO dto) {
        try {
            QuantidadeProduto quantidadeProduto = new QuantidadeProduto();
            quantidadeProduto.setProduto(dto.getProduto());
            quantidadeProduto.setQuantidade(dto.getQuantidade());
            repository.save(quantidadeProduto);
            return new ResponseEntity<>(quantidadeProduto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<QuantidadeProduto> criarQuantProdutoSimples(QuantidadeProdutoRequestSimplesDTO dto) {
        try {
            QuantidadeProduto quantidadeProduto = new QuantidadeProduto();
            quantidadeProduto.setProduto(produtoService.buscar(dto.getProdutoId()));
            quantidadeProduto.setQuantidade(dto.getQuantidade());
            repository.save(quantidadeProduto);
            return new ResponseEntity<>(quantidadeProduto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<QuantidadeProduto> buscarPorId(Long id) {
        try {
            QuantidadeProduto quantidadeProduto = repository.findById(id).get();
            return new ResponseEntity<>(quantidadeProduto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<QuantidadeProdutoResponseSimplesDTO> buscarPorIdSimples(Long id) {
        try {
            QuantidadeProduto quantidadeProduto = repository.findById(id).get();
            return new ResponseEntity<>(quantidadeProduto.paraSimplesResponseDTO(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<QuantidadeProduto>> buscarTodos(){
        try {
            List<QuantidadeProduto> quantidadeProdutos = repository.findAll();
            return new ResponseEntity<>(quantidadeProdutos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<QuantidadeProdutoResponseSimplesDTO>> buscarTodosSimples(){
        try {
            List<QuantidadeProduto> quantidadeProdutos = repository.findAll();
            List<QuantidadeProdutoResponseSimplesDTO> quantidadeDTO = new ArrayList<>();
            for(QuantidadeProduto quantidade: quantidadeProdutos){
                quantidadeDTO.add(quantidade.paraSimplesResponseDTO());
            }
            return new ResponseEntity<>(quantidadeDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<QuantidadeProduto> atualizar(Long id, QuantidadeProdutoRequestDTO dto) {
        try {
            QuantidadeProduto quantidadeProduto = repository.findById(id).get();
            quantidadeProduto.setProduto(dto.getProduto());
            quantidadeProduto.setQuantidade(dto.getQuantidade());
            repository.save(quantidadeProduto);
            return new ResponseEntity<>(quantidadeProduto, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
