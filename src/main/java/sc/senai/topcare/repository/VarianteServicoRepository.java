package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.VarianteServico;

@Repository
public interface VarianteServicoRepository extends JpaRepository<VarianteServico, Long> {
}
