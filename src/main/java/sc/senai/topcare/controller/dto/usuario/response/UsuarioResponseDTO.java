package sc.senai.topcare.controller.dto.usuario.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
        List<Pet> pets;
        List<Cartao> cartoes;
        List<Agendamento> agendamentos;
        List<Pedido> pedidos;

        public UsuarioResponseDTO(Usuario usuario){
                ModelMapperUtil.map(usuario, this);
        }
}
