package sc.senai.topcare.service.horario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.Horario;
import sc.senai.topcare.repository.HorarioRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class HorarioServiceImpl implements HorarioService {

    private HorarioRepository repository;

    @Override
    public List<Horario> buscarPorDiaELivre(LocalDate dia, Long id) {
        LocalDate hoje = LocalDate.now();
        LocalTime agora = LocalTime.now();

        List<Horario> horarios = repository.findAllByDiaAndReservadoAndFuncionario_Id(dia, false, id);

        if(dia.isEqual(hoje)){
            horarios.removeIf(horario -> horario.getHoraInicio().isBefore(agora));
        }
        return horarios;
    }

    @Override
    public void mudarReservado(Long id) {
        Horario horario = repository.findById(id).orElseThrow(NullPointerException::new);
        horario.setReservado(true);
        repository.save(horario);
    }
}
