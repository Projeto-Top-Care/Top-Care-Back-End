package sc.senai.topcare.controller.dto.usuario;

public record LoginRequestDTO(
        String email,
        String senha
) {
}
