package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
