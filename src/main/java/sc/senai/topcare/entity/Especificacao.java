package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.produto.EspecificacaoDTO;

@Entity
@Table(name = "especificacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Especificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String conteudo;

    public Especificacao(EspecificacaoDTO dto){
        this.nome = dto.getNome();
        this.conteudo = dto.getConteudo();
    }

}
