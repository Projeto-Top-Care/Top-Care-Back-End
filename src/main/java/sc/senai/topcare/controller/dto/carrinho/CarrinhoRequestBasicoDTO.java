package sc.senai.topcare.controller.dto.carrinho;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CarrinhoRequestBasicoDTO {
     @NotNull
     @Column(unique = true)
     Long usuarioId;
}
