package sc.senai.topcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sc.senai.topcare.entity.Agendamento;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.entity.Horario;

import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findAllByHorario_Funcionario_Id(Long id);
}
