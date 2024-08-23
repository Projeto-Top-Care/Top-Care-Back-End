package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private Funcionario profissional;

    @ManyToOne
    private Pet pet;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @ManyToOne
    private Pagamento pagamento;

}
