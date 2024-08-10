package sc.senai.topcare.controller.dto.usuario.request.usuario;

public record LoginRequestDTO(
        String email,
        String senha
) {
}
