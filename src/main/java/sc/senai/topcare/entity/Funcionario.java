package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "funcionario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Usuario{
    @ManyToMany(mappedBy = "funcionarios")
    private List<Servico> servicos;

    @ManyToOne
    private Filial filial;

    @OneToMany
    @JoinColumn(name = "id_funcionario")
    private List<Horario> horariosAgendados;


}
