package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl {

    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) throws Exception {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Produto não encontrado");
        }
    }

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

            List<Avaliacao> avaliacoes = produtoDTO.getAvaliacoes().stream()
                    .map(dto -> {

                        Avaliacao avaliacao = new Avaliacao();
                        BeanUtils.copyProperties(dto, avaliacao);
                        return avaliacao;

                    })
                    .collect(Collectors.toList());
            produto.setAvaliacao(avaliacoes);

            Produto savedProduto = produtoRepository.save(produto);
            return new ResponseEntity<>(savedProduto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
