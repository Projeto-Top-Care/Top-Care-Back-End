package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.service.interfaces.SubscriberService;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario implements SubscriberService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String email;
    private String celular;
    private String cpf;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private String senha;

    @Override
    public void update(String texto) {
        System.out.println("Nova atualização na Newsletter: " + texto);
    }
}
