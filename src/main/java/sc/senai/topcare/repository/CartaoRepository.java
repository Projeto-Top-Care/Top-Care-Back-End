package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
}
