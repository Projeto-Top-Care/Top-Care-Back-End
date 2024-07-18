package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
}
