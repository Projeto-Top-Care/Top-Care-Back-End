package sc.senai.topcare.service.horario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.horarios.HorarioResponseDTO;
import sc.senai.topcare.controller.dto.horarios.ReservarHorarioPatchDto;
import sc.senai.topcare.entity.Agendamento;
import sc.senai.topcare.entity.Horario;
import sc.senai.topcare.entity.Servico;
import sc.senai.topcare.repository.HorarioRepository;
import sc.senai.topcare.repository.ServicoRepository;
import sc.senai.topcare.repository.UsuarioRepository;

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
    public List<HorarioResponseDTO> verHorariosDisponiveis(Long id) {
        List<Horario> horarios = repository.findAllByFuncionario_Id(id);
        List<HorarioResponseDTO> horariosDTO = new ArrayList<>();
        for (Horario horario : horarios) {
            if (!horario.getReservado()) {
                horariosDTO.add(new HorarioResponseDTO(horario.getDia(), horario.getHoraInicio(), horario.getHoraFim()));
            }
        }
        return horariosDTO;
    }

    @Override
    public Boolean agendarHorario(Long id) {
        Horario horario = repository.findById(id).get();
        horario.setReservado(true);
        repository.save(horario);
        return true;
    }
}
