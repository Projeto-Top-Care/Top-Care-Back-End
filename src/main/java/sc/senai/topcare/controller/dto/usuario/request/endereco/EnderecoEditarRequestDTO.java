package sc.senai.topcare.controller.dto.usuario.request.endereco;

import sc.senai.topcare.entity.Estado;

public record EnderecoEditarRequestDTO(
        Long id,
        String cep,
        String cidade,
        String rua,
        String bairro,
        Estado estado,
        String nome,
        String complemento,
        Integer numero
) {
}
