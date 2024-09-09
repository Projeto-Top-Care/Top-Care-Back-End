package sc.senai.topcare.controller.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginaProdutos {
    Integer page;
    Integer pageSize;
    Integer totalPages;
    Long totalElements;
    List<ProdutoResponseCardDTO> produtos;

    public PaginaProdutos(Pageable page, Page<ProdutoResponseCardDTO> produtos){
        this.page = page.getPageNumber();
        this.pageSize = page.getPageSize();
        this.totalPages = produtos.getTotalPages();
        this.totalElements = produtos.getTotalElements();
        this.produtos = produtos.getContent();
    }
}
