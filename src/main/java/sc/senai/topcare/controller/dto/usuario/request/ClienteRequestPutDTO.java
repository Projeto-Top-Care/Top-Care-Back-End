package sc.senai.topcare.controller.dto.usuario.request;

import lombok.Getter;
import sc.senai.topcare.entity.Sexo;

import java.time.LocalDate;

@Getter
public class ClienteRequestPutDTO {
    private String nome;
    private String email;
    private String celular;
    private LocalDate dataNascimento;
    private Sexo sexo;
}
