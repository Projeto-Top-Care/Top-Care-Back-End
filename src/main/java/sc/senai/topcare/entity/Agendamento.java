package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.agendamento.AgendamentoRequestDTO;
import sc.senai.topcare.enuns.StatusAgendamento;
import sc.senai.topcare.utils.ModelMapperUtil;

@Entity
@Data
@Table(name = "agendamento")
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Filial local;

    private Double valor;

    @OneToOne
    private Horario horario;

    @ManyToOne
    @JoinColumn(name = "id_servico")
    private VarianteServico servico;

    @ManyToOne
    private Pet pet;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Pagamento pagamento;

    public Agendamento(AgendamentoRequestDTO dto){
        ModelMapperUtil.map(dto, this);
        this.status = StatusAgendamento.EM_ANDAMENTO;
    }
}
