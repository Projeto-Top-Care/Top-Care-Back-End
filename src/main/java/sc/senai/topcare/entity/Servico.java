package sc.senai.topcare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import sc.senai.topcare.controller.dto.servicos.ServicoRequestDTO;
import sc.senai.topcare.controller.dto.servicos.ServicoResponseDTO;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.util.List;

@Entity
@Table(name = "servico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    @OneToOne
    private File imagem;

    private String descricao;

    @ManyToMany
    private List<Funcionario> funcionarios;

    @ManyToMany
    private List<Especie> especies;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_servico")
    private List<VarianteServico> variantes;

    public Servico(ServicoRequestDTO dto){
        System.out.println(dto);
        ModelMapperUtil.map(dto, this);
    }

    public ServicoResponseDTO editar(ServicoRequestDTO dto) {
        BeanUtils.copyProperties(dto, this);
        return new ServicoResponseDTO(this);
    }
}
