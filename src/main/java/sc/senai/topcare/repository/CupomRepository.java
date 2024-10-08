package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Cupom;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {
}
