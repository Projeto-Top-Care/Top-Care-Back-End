package sc.senai.topcare.factory;

import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPostDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Usuario;

public class CriadorCliente extends CriadorUsuario{
    @Override
    public Usuario criarUsuario() {
        return new Cliente();
    }
    public Cliente criarUsuario(ClienteRequestPostDTO dto){
        return new Cliente(dto);
    }
}
