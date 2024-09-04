package sc.senai.topcare.service.horario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.horarios.HorarioResponseDTO;
import sc.senai.topcare.entity.Horario;
import sc.senai.topcare.repository.HorarioRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HorarioServiceImpl implements HorarioService {

    private HorarioRepository repository;

    @Override
    public List<Horario> buscarPorDiaELivre(LocalDate dia, Long id) {
        return repository.findAllByDiaAndReservadoAndFuncionario_Id(dia, false, id);
    }

    @Override
    public void mudarReservado(Long id) {
        Horario horario = repository.findById(id).orElseThrow(NullPointerException::new);
        horario.setReservado(true);
        repository.save(horario);
    }

    @Override
    public List<HorarioResponseDTO> verHorariosPorUsuario(Long id) {
        List<Horario> horarios = repository.findAllByFuncionario_Id(id);
        List<HorarioResponseDTO> horariosDTO = new ArrayList<>();
        for (Horario horario : horarios) {
            horariosDTO.add(new HorarioResponseDTO(horario.getHoraInicio(), horario.getHoraFim()));
        }
        return horariosDTO;
    }
}
