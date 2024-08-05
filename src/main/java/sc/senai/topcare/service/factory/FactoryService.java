package sc.senai.topcare.service.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPostDTO;
import sc.senai.topcare.controller.factory.FuncionarioRequestDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.factory.CriadorCliente;
import sc.senai.topcare.factory.CriadorFuncionario;
import sc.senai.topcare.repository.ClienteRepository;
import sc.senai.topcare.repository.FuncionarioRepository;

@Service
@RequiredArgsConstructor
public class FactoryService {

    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    public Cliente criarCliente(ClienteRequestPostDTO dto){
        CriadorCliente c = new CriadorCliente();

        Cliente cliente = c.criarUsuario(dto);

        return clienteRepository.save(cliente);
    }

    public Funcionario criarFuncionario(FuncionarioRequestDTO dto){
        CriadorFuncionario c = new CriadorFuncionario();

        Funcionario funcionario = c.criarUsuario(dto);

        return funcionarioRepository.save(funcionario);
    }

}
