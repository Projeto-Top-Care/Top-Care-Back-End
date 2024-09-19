package sc.senai.topcare.service.produto;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.controller.dto.produto.*;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.repository.ImagemRepository;
import sc.senai.topcare.repository.ProdutoRepository;
import sc.senai.topcare.exceptions.ProdutoNaoEncontradoException;
import sc.senai.topcare.repository.VarianteProdutoRepository;
import sc.senai.topcare.service.imagem.ImagemService;
import sc.senai.topcare.utils.ModelMapperUtil;
import sc.senai.topcare.utils.ProdutoSpecification;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ImagemService imagemService;
    private final VarianteProdutoRepository varianteRepository;

    private List<Produto> produtosPagina = new ArrayList<>();

    @Override
    public PaginaProdutos buscarTodosProdutos(Pageable pageable, String query) {
        Page<Produto> produtos;
        if(query.equals("empty")){
            produtos = produtoRepository.findAll(pageable);
        }else{
            produtos = produtoRepository.findAllByNomeContainingIgnoreCase(query, pageable);
        }
        produtosPagina = produtos.getContent();
        Page<ProdutoResponseCardDTO> produtosCard = produtos.map(ProdutoResponseCardDTO::new);
        return new PaginaProdutos(pageable, produtosCard);
    }

    @Override
    public List<ProdutoCompletoResponseDTO> buscarTodosCompleto(){
        return produtosPagina.stream().map(ProdutoCompletoResponseDTO::new).toList();
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
        if(query.equals("marcas")) return buscarMarcas();

        if(query.equals("categorias")) return buscarCategorias();

        if(query.equals("especies")) return buscarEspecies();

        throw new IllegalArgumentException("Filtro não encontrado");
    }

    private List<String> buscarMarcas(){
        Set<String> marcas = new HashSet<>();
        for(Produto produto : produtosPagina){
            marcas.add(produto.getMarca());
        }
        return new ArrayList<>(marcas);
    }

    private List<String> buscarCategorias(){
        Set<String> categorias = new HashSet<>();
        for(Produto produto : produtosPagina){
            categorias.add(produto.getCategoria().getNome());
        }
        return new ArrayList<>(categorias);
    }

    private List<String> buscarEspecies(){
        Set<String> especies = new HashSet<>();
        for(Produto produto : produtosPagina){
            for(Especie especie : produto.getEspecies()){
                especies.add(especie.getNome());
            }
        }
        return new ArrayList<>(especies);
    }


    public List<ProdutoResponseCardDTO> buscarFiltrados(List<String> marcas, List<String> categorias, List<String> especies, Pageable pageable) {

        Specification<Produto> spec = Specification.where(null);

        if (marcas != null && !marcas.isEmpty()) {
            spec = spec.and(ProdutoSpecification.marcasIn(marcas));
        }

        if (categorias != null && !categorias.isEmpty()) {
            spec = spec.and(ProdutoSpecification.categoriasIn(categorias));
        }

        if (especies != null && !especies.isEmpty()) {
            spec = spec.and(ProdutoSpecification.especiesIn(especies));
        }
        List<Produto> filtrados = produtoRepository.findAll(spec, pageable).stream().toList();
        List<Produto> filtradosByQuery = new ArrayList<>();

        for(Produto produto : produtosPagina){
            for(Produto produtoFiltrado : filtrados){
                if(produto.getId().equals(produtoFiltrado.getId())){
                    filtradosByQuery.add(produto);
                }
            }
        }
        return filtradosByQuery.stream().map(ProdutoResponseCardDTO::new).toList();
    }

    public VarianteProdutoDTO buscarVariante(Long id) {
        VarianteProduto varianteProduto = varianteRepository.findById(id).orElseThrow(()->
                new NoSuchElementException("A variante não foi localizada!"));
        return new VarianteProdutoDTO(varianteProduto);
    }
}
