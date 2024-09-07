package sc.senai.topcare.service.produto;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.controller.dto.produto.PaginaProdutos;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.controller.dto.produto.ProdutoResponseCardDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.repository.ImagemRepository;
import sc.senai.topcare.repository.ProdutoRepository;
import sc.senai.topcare.exceptions.ProdutoNaoEncontradoException;
import sc.senai.topcare.service.imagem.ImagemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepository;
    private ImagemService imagemService;

    @Override
    public PaginaProdutos buscarTodosProdutos(Pageable pageable) {
        Page<ProdutoResponseCardDTO> produtos = produtoRepository.findAll(pageable).map(ProdutoResponseCardDTO::new);
        return new PaginaProdutos(pageable, produtos);
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
    public void cadastroProduto(ProdutoRequestDTO produtoDTO, List<MultipartFile> files) {
        Produto produto = new Produto(produtoDTO);
        List<Imagem> imagensProduto = produto.getImagens();
        for(MultipartFile file: files){
            Imagem imagem = imagemService.salvarImagem(file);
            imagensProduto.add(imagem);
        }
        produto.setImagens(imagensProduto);
        produtoRepository.save(produto);
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
