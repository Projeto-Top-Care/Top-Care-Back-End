package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sc.senai.topcare.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
