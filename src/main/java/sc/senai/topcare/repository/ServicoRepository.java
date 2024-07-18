package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
