package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Long> {
    Filial findByNome(String nome);
}
