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

    @ManyToOne
    private Servico servico;

    private LocalDateTime horario;

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

    public Agendamento(Filial local, Double valor, Servico servico, LocalDateTime horario,
                       Funcionario profissional, Pet pet, Cliente cliente,
                       Pagamento pagamento) {
        this.local = local;
        this.valor = valor;
        this.servico = servico;
        this.horario = horario;
        this.profissional = profissional;
        this.pet = pet;
        this.cliente = cliente;
        this.pagamento = pagamento;
    }
}
