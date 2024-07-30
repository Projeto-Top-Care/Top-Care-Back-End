package sc.senai.topcare.controller.dto.usuario.request.endereco;

import sc.senai.topcare.entity.Estado;

public record EnderecoRequestDTO(
        Long idUsuario,
        String bairro,
        String rua,
        String cidade,
        String cep,
        String nome,
        String complemento,
        Integer numero,
        Estado estado
) {
}
