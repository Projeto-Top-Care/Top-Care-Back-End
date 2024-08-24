package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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

    @Column(nullable = false, length = 6, unique = true)
    private Long codigo;

    public Funcionario(String nome, Long codigo, Role role, String email, String celular, String cpf,
                       LocalDate dataNascimento, Sexo sexo, String senha, Filial filial) {
        this.setNome(nome);
        this.codigo = codigo;
        this.setRole(role);
        this.setEmail(email);
        this.setCelular(celular);
        this.setCpf(cpf);
        this.setDataNascimento(dataNascimento);
        this.setSexo(sexo);
        this.setSenha(senha);
        this.filial = filial;
    }

    public Funcionario(String nome, String email, String celular, LocalDate dataNascimento,
                       Sexo sexo, Filial filial) {
        this.setNome(nome);
        this.setEmail(email);
        this.setCelular(celular);
        this.setDataNascimento(dataNascimento);
        this.setSexo(sexo);
        this.filial = filial;
    }
}
