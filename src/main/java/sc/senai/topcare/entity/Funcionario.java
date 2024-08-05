package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.factory.FuncionarioRequestDTO;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "funcionario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Usuario{
    @ManyToMany(mappedBy = "funcionarios")
    private List<Servico> servicos = new ArrayList<>();

    @ManyToOne
    private Filial filial;

    @OneToMany
    @JoinColumn(name = "id_funcionario")
    private List<Horario> horariosAgendados = new ArrayList<>();

    public Funcionario(FuncionarioRequestDTO dto){
        super(dto);
        this.setFilial(dto.getFilial());
    }

}
