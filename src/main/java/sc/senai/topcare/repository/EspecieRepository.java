package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.topcare.entity.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Long> {
}
