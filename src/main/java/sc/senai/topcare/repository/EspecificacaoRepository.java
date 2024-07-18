package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Especificacao;

@Repository
public interface EspecificacaoRepository extends JpaRepository<Especificacao, Long> {
}
