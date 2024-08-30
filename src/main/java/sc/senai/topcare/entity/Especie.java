package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@Table(name = "especie")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Especie {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "especies")
    @ToString.Exclude
    private List<Servico> servicos = new ArrayList<>();
}
