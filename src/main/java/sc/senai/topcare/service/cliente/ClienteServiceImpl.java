package sc.senai.topcare.service.cliente;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.cliente.ClienteRequestPutDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.exceptions.UsuarioExistenteExeption;
import sc.senai.topcare.repository.ClienteRepository;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clientRepository;

    @Override
    public Cliente salvar(Cliente cliente){
        return clientRepository.save(cliente);
    }

    @Override
    public Cliente editar(ClienteRequestPutDTO dto, Long id) {
        Cliente cliente = buscarCliente(id);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, cliente);
        return clientRepository.save(cliente);
    }

    @Override
    public Cliente buscarCliente(Long id){
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }


    @Override
    public void cadastro(ClienteRequestPostDTO usuarioDTO) {
        try{
            if(clientRepository.existsByCpf(usuarioDTO.getCpf())){
                throw new UsuarioExistenteExeption("O CPF já existe no sistema!");
            }
            Cliente usuario = new Cliente(usuarioDTO);
            clientRepository.save(usuario);
        }catch (UsuarioExistenteExeption e){
            System.out.println(e.getMessage());
        }
    }
}
