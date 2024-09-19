package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Carrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    Carrinho findByUsuarioId(Long id);
    @Query("SELECT p FROM Carrinho p JOIN p.produtos i WHERE i.id = :itemId")
    Carrinho findByQuantidadeProdutoId(@Param("itemId") Long itemId);
}
