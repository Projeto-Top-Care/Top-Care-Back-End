package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.cartao.CartaoRequestDTO;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.time.LocalDate;

@Entity
@Table(name = "cartao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeNoCartao;

    private String nomeDoCartao;

    private String cpf;

    private String numero;

    private String validade;

    public Cartao(CartaoRequestDTO dto){
        ModelMapperUtil.map(dto, this);
    }
}
