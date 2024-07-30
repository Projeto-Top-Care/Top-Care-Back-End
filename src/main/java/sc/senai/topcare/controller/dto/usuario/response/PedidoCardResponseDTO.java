package sc.senai.topcare.controller.dto.usuario.response;

public record PedidoCardResponseDTO(
        Long id,
        String dataCompra,
        Long codigo,
        String status,
        Double total
) {
}
