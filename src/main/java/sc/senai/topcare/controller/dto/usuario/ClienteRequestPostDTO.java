package sc.senai.topcare.controller.dto.usuario;

import sc.senai.topcare.entity.Endereco;
import sc.senai.topcare.entity.Estado;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.entity.Sexo;

import java.time.LocalDate;

public record ClienteRequestPostDTO(
        String nome,
        LocalDate dataNascimento,
        String email,
        String celular,
        String cpf,
        Sexo sexo,
        String senha,
        String bairro,
        String rua,
        String cep,
        Integer numero,
        Estado estado,
        String cidade,
        String nomeEndereco,
        String complemento,
        Pet pet

) {
}
