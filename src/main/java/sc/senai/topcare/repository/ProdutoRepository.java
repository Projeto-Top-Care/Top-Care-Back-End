package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
