package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "servico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;

    @OneToOne
    private File imagem;

    private String descricao;

    @ManyToMany
    private List<Funcionario> funcionarios;

    @ManyToMany
    private List<Especie> especies;

    @OneToMany
    @JoinColumn(name = "id_servico")
    private List<VarianteServico> variantes;

}
