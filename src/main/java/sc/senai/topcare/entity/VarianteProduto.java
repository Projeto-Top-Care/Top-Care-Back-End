package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "variante_produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VarianteProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoVariante tipoVariante;

    private Double preco;

    private Double desconto;

    private Integer estoque;

    private Double precoDesconto;

}
