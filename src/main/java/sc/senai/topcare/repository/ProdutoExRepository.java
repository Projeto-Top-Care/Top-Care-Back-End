package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.ProdutoEx;
import sc.senai.topcare.service.interfaces.CarrinhoComponent;

@Repository
public interface ProdutoExRepository extends JpaRepository<ProdutoEx, Long> {

}
