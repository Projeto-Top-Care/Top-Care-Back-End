package sc.senai.topcare.controller.dto.usuario.request.cliente;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import sc.senai.topcare.entity.Estado;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.entity.Sexo;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
public class ClienteRequestPostDTO {
    @NotEmpty
    @Size(max = 50)
    String bairro;
    @NotEmpty
    String celular;
    @NotEmpty
    String cep;
    @NotEmpty
    String cidade;
    String complemento;
    @NotEmpty
    String cpf;
    @Past @NotNull
    LocalDate dataNascimento;
    @Email
    String email;
    @NotNull
    Estado estado;
    @NotEmpty
    String nome;
    @NotEmpty
    String nomeEndereco;
    @Positive @NotNull @Digits(integer = 5, fraction = 0)
    Integer numero;
    @NotEmpty
    String rua;
    @NotEmpty
//    @Pattern(regexp = "/(?=.*/d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}/")
    String senha;
    @NotNull
    Sexo sexo;
    @NotNull
    Pet pet;
}
