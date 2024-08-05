package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPostDTO;
import sc.senai.topcare.controller.factory.FuncionarioRequestDTO;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @OneToOne
//    private File foto;

    private String nome;

    private String email;

    private String celular;

    private String cpf;

    private LocalDate dataNascimento;

    private Sexo sexo;

    private String senha;

    public Usuario(ClienteRequestPostDTO dto){
        BeanUtils.copyProperties(dto, this);
    }

    public Usuario(FuncionarioRequestDTO dto){
        BeanUtils.copyProperties(dto, this);
    }
}
