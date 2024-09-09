package sc.senai.topcare.controller.dto.agendamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.usuario.response.pet.PetResponseDTO;
import sc.senai.topcare.entity.Agendamento;
import sc.senai.topcare.entity.Pagamento;
import sc.senai.topcare.entity.VarianteServico;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendamentoResponseDTO {
    Long id;
    String filial;
    HorarioResponseDTO horario;
    VarianteServico varianteServico;
    PetResponseDTO pet;
    String status;
    String cliente;
    PagamentoResponseDTO pagamento;
    String statusAgendamento;

    public AgendamentoResponseDTO(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.filial = agendamento.getLocal().getNome();
        this.horario = new HorarioResponseDTO(agendamento.getHorario());
        this.varianteServico = agendamento.getServico();
        this.pet = new PetResponseDTO(agendamento.getPet());
        this.status = agendamento.getStatus().getNOME();
        this.cliente = agendamento.getCliente().getNome();
        this.pagamento = new PagamentoResponseDTO(agendamento.getPagamento());
    }
}
