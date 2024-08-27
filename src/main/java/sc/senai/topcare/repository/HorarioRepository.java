package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Horario;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    List<Horario> findAllByDiaAndReservadoAndFuncionario_Id(LocalDate dia, Boolean reservado, Long id);
    List<Horario> findAllByFuncionario_Id(Long id);
    List<Horario> findAllByReservado(Boolean reservado);
    List<Horario> findByDia(LocalDate dia);
}
