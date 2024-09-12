package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name = "imagem")
@AllArgsConstructor
@NoArgsConstructor

public class Imagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String referencia;

    private String nomeOriginal;

    @Column(columnDefinition = "TEXT")
    private String caminho;
}

