package sc.senai.topcare.factory;

import sc.senai.topcare.controller.factory.FuncionarioRequestDTO;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.entity.Usuario;

public class CriadorFuncionario extends CriadorUsuario{
    @Override
    public Usuario criarUsuario() {
        return new Funcionario();
    }

    public Funcionario criarUsuario(FuncionarioRequestDTO dto){
        return new Funcionario(dto);
    }
}
