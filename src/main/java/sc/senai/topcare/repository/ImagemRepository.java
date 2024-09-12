package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Imagem;

import java.util.Optional;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
    Optional<Imagem> findByCaminho(String caminho);
}
