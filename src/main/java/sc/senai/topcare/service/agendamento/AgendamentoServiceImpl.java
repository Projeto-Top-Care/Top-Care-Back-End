package sc.senai.topcare.service.agendamento;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.agendamento.AgendamentoRequestDTO;
import sc.senai.topcare.controller.dto.agendamento.AgendamentoResponseDTO;
import sc.senai.topcare.entity.Agendamento;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Pagamento;
import sc.senai.topcare.entity.Usuario;
import sc.senai.topcare.repository.AgendamentoRepository;
import sc.senai.topcare.service.cliente.ClienteService;
import sc.senai.topcare.service.horario.HorarioService;
import sc.senai.topcare.service.usuario.UsuarioService;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AgendamentoServiceImpl implements AgendamentoService{

    private final AgendamentoRepository repository;
    private final ClienteService clienteService;
    private final HorarioService horarioService;

    @Override
    public Long criarAgendamento(AgendamentoRequestDTO dto, Long id) {
        Agendamento agendamento = new Agendamento(dto);

        Cliente cliente = clienteService.buscarCliente(id);
        cliente.getAgendamentos().add(agendamento);
        agendamento.setCliente(cliente);

        horarioService.mudarReservado(dto.getHorario().getId());

        repository.save(agendamento);
        return agendamento.getId();
    }

    @Override
    public AgendamentoResponseDTO buscarPorId(Long id) {
        Agendamento agendamento = repository.findById(id).orElseThrow(NullPointerException::new);
        return new AgendamentoResponseDTO(agendamento);
    }

    @Override
    public void confirmarPagamento(Long id) {
        Agendamento agendamento = repository.findById(id).orElseThrow(NullPointerException::new);
        LocalDateTime agora = LocalDateTime.now();
        if(Duration.between(agendamento.getHorarioConfirmacao(), agora).toHours() > 1){
            deletarPorId(agendamento.getId());
            throw new RuntimeException("Tempo de confirmação excedido");
        }else{
            agendamento.getPagamento().setPago(true);
            repository.save(agendamento);
        }
    }

    public void deletarPorId(Long id) {
        Agendamento agendamento = repository.findById(id).orElseThrow(NullPointerException::new);
        agendamento.getHorario().setReservado(false);
        repository.save(agendamento);
        repository.deleteById(id);
    }

    @Override
    public void excluirAgendamento(Long id) {
        if(podeExcluir(id)){
            deletarPorId(id);
        }else {
            throw new RuntimeException("Tempo de exclusão excedido");
        }
    }

    @Override
    public Boolean podeExcluir(Long id) {
        Agendamento agendamento = repository.findById(id).orElseThrow(NullPointerException::new);
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime horarioAgendamento = agendamento.getHorario().getDia().atTime(agendamento.getHorario().getHoraInicio());
        return Duration.between(hoje, horarioAgendamento).toDays() >= 1;
    }
}
