package sc.senai.topcare.facade;

import lombok.AllArgsConstructor;
import sc.senai.topcare.controller.dto.usuario.request.AgendamentoPostDto;
import sc.senai.topcare.entity.Agendamento;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.StatusAgendamento;
import sc.senai.topcare.service.implement.AgendamentoServiceImpl;
import sc.senai.topcare.service.implement.UsuarioServiceImpl;

@AllArgsConstructor
public class PostFacade {

    private final UsuarioServiceImpl usuarioService;

    public Agendamento postAgendamento(AgendamentoPostDto agendamentoPostDto) {
        Cliente cliente = usuarioService.buscarCliente(agendamentoPostDto.idCliente());
        Agendamento novoAgendamento = new Agendamento(
                agendamentoPostDto.local(),
                agendamentoPostDto.valor(),
                agendamentoPostDto.servico(),
                agendamentoPostDto.horario(),
                agendamentoPostDto.profissional(),
                agendamentoPostDto.pet(), cliente,
                agendamentoPostDto.pagamento());
        novoAgendamento.setStatus(StatusAgendamento.AGUARDANDO_CLIENTE);
        return novoAgendamento;
    }

}
