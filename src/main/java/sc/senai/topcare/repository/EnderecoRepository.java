package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
