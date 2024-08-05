package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPostDTO;

@Entity
@Table(name = "endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cep;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private String cidade;

    private String bairro;

    private String rua;

    private Integer numero;

    private String complemento;

    public Endereco(ClienteRequestPostDTO dto){
        BeanUtils.copyProperties(dto, this);
    }
}
