package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.repository.ProdutoRepository;
import sc.senai.topcare.service.interfaces.ProdutoService;
import sc.senai.topcare.exceptions.ProdutoNaoEncontradoException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;
    @Override
    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }
    @Override
    public Produto buscarProdutoPorId(Long id) throws Exception {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Produto não encontrado");
        }
    }
    @Override
    public ResponseEntity<Produto> cadastroProduto(ProdutoRequestDTO produtoDTO) {
        try {
            Produto produto = new Produto();

            BeanUtils.copyProperties(produtoDTO, produto);

            List<VarianteProduto> variantes = produtoDTO.getVariantes().stream()
                    .map(dto -> {

                        VarianteProduto variante = new VarianteProduto();
                        BeanUtils.copyProperties(dto, variante);
                        return variante;

                    })
                    .collect(Collectors.toList());
            produto.setVariantes(variantes);

            List<Especificacao> especificacoes = produtoDTO.getEspecificacoes().stream()
                    .map(dto -> {

                        Especificacao especificacao = new Especificacao();
                        BeanUtils.copyProperties(dto, especificacao);
                        return especificacao;

                    })
                    .collect(Collectors.toList());
            produto.setEspecificacao(especificacoes);

            Produto savedProduto = produtoRepository.save(produto);
            return new ResponseEntity<>(savedProduto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Produto buscar(Long id) {
        try{
            return produtoRepository.findById(id).orElseThrow(ProdutoNaoEncontradoException::new);
        }catch (ProdutoNaoEncontradoException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
   
    @Override
    public String deletarProduto(Long id){
        String nome = buscar(id).getNome();
        produtoRepository.deleteById(id);
        return nome + " excluido!";
    }
    @Override
    public Produto atualizarProduto(Long id, ProdutoRequestDTO produtoRequestDTO) {
        Produto produto = buscar(id);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(produtoRequestDTO, produto);
        return produtoRepository.save(produto);
    }

}
