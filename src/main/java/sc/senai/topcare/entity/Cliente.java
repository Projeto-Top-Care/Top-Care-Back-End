package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private List<Pet> pets;

    @ManyToMany
    private List<Produto> favoritos;

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Cartao> cartoes;

    @ManyToMany
    private List<Cupom> cupons;
}
