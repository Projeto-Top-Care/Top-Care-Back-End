package sc.senai.topcare.controller.dto.usuario;

import sc.senai.topcare.entity.Endereco;
import sc.senai.topcare.entity.Estado;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.entity.Sexo;

import java.time.LocalDate;

public record ClienteRequestPostDTO(
        String bairro,
        String celular,
        String cep,
        String cidade,
        String complemento,
        String cpf,
        LocalDate dataNascimento,
        String email,
        Estado estado,
        String nome,
        String nomeEndereco,
        Integer numero,
        String rua,
        String senha,
<<<<<<< HEAD
        Sexo sexo,
=======
        String bairro,
        String rua,
        String cep,
        Integer numero,
        Estado estado,
        String cidade,
        String nomeEndereco,
        String complemento,
>>>>>>> 5d089df4c418d9d4c3758d95b735a215c2825090
        Pet pet

) {
}
