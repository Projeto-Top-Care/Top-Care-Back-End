package sc.senai.topcare.controller.dto.usuario.request;

public record LoginRequestDTO(
        String email,
        String senha
) {
}
