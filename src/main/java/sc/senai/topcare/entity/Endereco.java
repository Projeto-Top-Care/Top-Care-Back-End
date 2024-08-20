package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.*;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.utils.ModelMapperUtil;

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

    public Endereco(ClienteRequestPostDTO dto) {
        ModelMapperUtil.map(dto, this);
        this.nome = dto.getNomeEndereco();
    }

    public Endereco(EnderecoRequestDTO dto){
        ModelMapperUtil.map(dto, this);
    }
}
