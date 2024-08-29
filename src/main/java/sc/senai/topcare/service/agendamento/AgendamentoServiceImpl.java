package sc.senai.topcare.service.agendamento;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.agendamento.AgendamentoRequestDTO;
import sc.senai.topcare.entity.Agendamento;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Usuario;
import sc.senai.topcare.repository.AgendamentoRepository;
import sc.senai.topcare.service.cliente.ClienteService;
import sc.senai.topcare.service.horario.HorarioService;
import sc.senai.topcare.service.usuario.UsuarioService;

@Service
@AllArgsConstructor
public class AgendamentoServiceImpl implements AgendamentoService{

    private final AgendamentoRepository repository;
    private final ClienteService clienteService;
    private final HorarioService horarioService;

    @Override
    public Boolean criarAgendamento(AgendamentoRequestDTO dto, Long id) {
        Agendamento agendamento = new Agendamento(dto);

        Cliente cliente = clienteService.buscarCliente(id);
        cliente.getAgendamentos().add(agendamento);
        agendamento.setCliente(cliente);

        horarioService.mudarReservado(dto.getHorario().getId());

        repository.save(agendamento);
        return true;
    }
}
