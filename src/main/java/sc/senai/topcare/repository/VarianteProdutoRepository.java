package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.VarianteProduto;

@Repository
public interface VarianteProdutoRepository extends JpaRepository<VarianteProduto, Long> {
}
