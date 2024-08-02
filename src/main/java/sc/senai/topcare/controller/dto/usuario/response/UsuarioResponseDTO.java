package sc.senai.topcare.controller.dto.usuario.response;

import lombok.Data;
import sc.senai.topcare.entity.*;

import java.time.LocalDate;
import java.util.List;

@Data
public class UsuarioResponseDTO{
        Long id;
        String nome;
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
}
