package sc.senai.topcare.service.horario;

import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.Horario;

import java.time.LocalDate;
import java.util.List;
@Service
public interface HorarioService {

    List<Horario> buscarPorDiaELivre(LocalDate dia, Long id);
    void mudarReservado(Long id);

}
