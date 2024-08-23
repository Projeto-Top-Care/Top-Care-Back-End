package sc.senai.topcare.controller.dto.usuario.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.controller.dto.usuario.response.pet.PetResponseDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO{
        Long id;
        String nome;
        Role role;
        String email;
        String celular;
        String cpf;
        LocalDate dataNascimento;
        Sexo sexo;
        List<Endereco> enderecos;
        List<PetResponseDTO> pets;
        List<Cartao> cartoes;
        List<Agendamento> agendamentos;
        List<Pedido> pedidos;

        public UsuarioResponseDTO(Usuario usuario){
                if(usuario instanceof Cliente cliente){
                        List<Pet> pets1 = cliente.getPets();
                        cliente.setPets(null);
                        ModelMapperUtil.map(usuario, this);
                        this.pets = pets1.stream().map(PetResponseDTO::new).toList();
                }else{
                        ModelMapperUtil.map(usuario,this);
                }
        }
}
