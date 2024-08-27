package sc.senai.topcare.controller.dto.agendamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgendamentoRequestDTO {
    Filial local;
    Double valor;
    Horario horario;
    VarianteServico varianteServico;
    Pet pet;
    Cliente cliente;
    Pagamento pagamento;
}
