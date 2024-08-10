package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;

@Entity
@Table(name = "pet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Especie especie;

    private String raca;

    @Enumerated(EnumType.STRING)
    private Porte porte;

    public Pet(PetRequestDTO petRequestDTO) {
        this.setEspecie(new Especie(petRequestDTO.getIdEspecie()));
        BeanUtils.copyProperties(petRequestDTO, this);
    }
}
