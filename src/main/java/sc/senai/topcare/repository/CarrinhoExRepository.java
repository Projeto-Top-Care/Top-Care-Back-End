package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.CarrinhoEx;
@Repository
public interface CarrinhoExRepository extends JpaRepository<CarrinhoEx, Long> {
}
