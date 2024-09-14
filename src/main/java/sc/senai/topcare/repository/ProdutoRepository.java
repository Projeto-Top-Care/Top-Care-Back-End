package sc.senai.topcare.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.controller.dto.produto.ProdutoCompletoResponseDTO;
import sc.senai.topcare.entity.Produto;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByNome(String nome);

    Page<Produto> findAllByNomeContainingIgnoreCase(String filtro, Pageable pageable);

    List<Produto> findAll(Specification<Produto> spec, Pageable pageable);
}
