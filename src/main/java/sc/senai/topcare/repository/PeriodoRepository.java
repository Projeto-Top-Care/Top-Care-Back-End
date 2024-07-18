package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Periodo;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Long> {
}
