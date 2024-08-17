package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.*;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_usuario")
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_usuario")
    private List<Pet> pets = new ArrayList<>();

    @ManyToMany
    private List<Produto> favoritos = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private List<Cartao> cartoes = new ArrayList<>();

    @ManyToMany
    private List<Cupom> cupons = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Cliente(ClienteRequestPostDTO dto){
        ModelMapperUtil.map(dto, this);
        this.enderecos.add(new Endereco(dto));
    }

    public UsuarioResponseDTO toDTO(){
        return new UsuarioResponseDTO(this);
    }

}
