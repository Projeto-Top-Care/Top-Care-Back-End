package sc.senai.topcare.controller.dto.usuario.request;

import sc.senai.topcare.entity.*;

import java.time.LocalDateTime;

public record AgendamentoPostDto(Filial local, Double valor, Servico servico,
                                 LocalDateTime horario, Funcionario profissional,
                                 Pet pet, Long idCliente, Pagamento pagamento) {
}
