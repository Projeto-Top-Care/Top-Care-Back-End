package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.QuantidadeProduto;

@Repository
public interface QuantidadeProdutoRepository extends JpaRepository<QuantidadeProduto, Long> {
}
