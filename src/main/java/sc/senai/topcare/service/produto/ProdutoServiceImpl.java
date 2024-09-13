package sc.senai.topcare.service.produto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.controller.dto.produto.PaginaProdutos;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestPutDTO;
import sc.senai.topcare.controller.dto.produto.ProdutoResponseCardDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.repository.ImagemRepository;
import sc.senai.topcare.repository.ProdutoRepository;
import sc.senai.topcare.exceptions.ProdutoNaoEncontradoException;
import sc.senai.topcare.service.imagem.ImagemService;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ImagemService imagemService;

    @Override
    public PaginaProdutos buscarTodosProdutos(Pageable pageable, String query) {
        Page<Produto> produtos;
        if(query.equals("empty")){
            produtos = produtoRepository.findAll(pageable);
        }else{
            produtos = produtoRepository.findAllByNomeContainingIgnoreCase(query, pageable);
        }
        Page<ProdutoResponseCardDTO> produtosCard = produtos.map(ProdutoResponseCardDTO::new);
        return new PaginaProdutos(pageable, produtosCard);
    }

    @Override
    public List<Produto> buscarTodosCompleto(String query){
        List<Produto> produtos;
        if(query.equals("empty")){
            produtos = produtoRepository.findAll();
        }else{
            produtos = produtoRepository.findAllByNomeContainingIgnoreCase(query);
        }
        return produtos;
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
        Produto produto = buscar(id);
        System.out.println(produto.getNome());
        for(Imagem imagem: produto.getImagens()){
            imagemService.deletarImagem(imagem.getId());
        }
        produtoRepository.deleteById(id);
        System.out.println("Cheguei aqui");
        return " excluido!";
    }
    @Override
    public Produto atualizarProduto(Long id, ProdutoRequestPutDTO produtoRequestDTO, List<MultipartFile> files) {
        Produto produto = buscar(id);

        //excluindo as imagens que foram pedidas (se tiver)
        for(String caminho : produtoRequestDTO.getImagensDeletar()){
            imagemService.deletarImagem(caminho);
        }

        //adicionando as novas imagens
        if(files != null){
            List<Imagem> imagensProduto = produto.getImagens();
            for(MultipartFile file: files){
                Imagem imagem = imagemService.salvarImagem(file);
                imagensProduto.add(imagem);
            }
            produto.setImagens(imagensProduto);
        }

        //atualizando as especificações
        produto.getEspecificacoes().clear();
        for(Especificacao especificacao : produtoRequestDTO.getEspecificacoes().stream().map(Especificacao::new).toList()){
            produto.getEspecificacoes().add(especificacao);
        }

        //atualizando as variantes
        produto.getVariantes().clear();
        for(VarianteProduto varianteProduto : produtoRequestDTO.getVariantes().stream().map(VarianteProduto::new).toList()){
            produto.getVariantes().add(varianteProduto);
        }

        //atualizando o produto
        BeanUtils.copyProperties(produtoRequestDTO, produto);
        return produtoRepository.save(produto);
    }

    @Override
    public List<String> buscarFiltros(String query) {
        return new ArrayList<>();
    }

}
