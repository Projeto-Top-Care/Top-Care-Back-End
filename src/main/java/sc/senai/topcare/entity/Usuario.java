package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.*;
import sc.senai.topcare.enuns.Role;
import sc.senai.topcare.enuns.Sexo;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "imagem_id")
    private Imagem imagem;

    private String nome;

    private Role role;

    private String email;

    private String celular;

    private String cpf;

    private LocalDate dataNascimento;

    private Sexo sexo;

    private String senha;
}
