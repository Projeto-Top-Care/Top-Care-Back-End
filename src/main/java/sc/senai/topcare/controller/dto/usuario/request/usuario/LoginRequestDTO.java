package sc.senai.topcare.controller.dto.usuario.request.usuario;

import jakarta.validation.constraints.NotNull;

public record LoginRequestDTO(
        @NotNull
        String email,
        String senha
) {
}
