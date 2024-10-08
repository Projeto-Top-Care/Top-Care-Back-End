package sc.senai.topcare.controller.dto.usuario.request.cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sc.senai.topcare.enuns.Estado;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.enuns.Sexo;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class ClienteRequestPostDTO {
    String bairro;
    String celular;
    String cep;
    String cidade;
    String complemento;
    String cpf;
    LocalDate dataNascimento;
    String email;
    Estado estado;
    String nome;
    String nomeEndereco;
    Integer numero;
    String rua;
    String senha;
    Sexo sexo;
    Pet pet;
}
