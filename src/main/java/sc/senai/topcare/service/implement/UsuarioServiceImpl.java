package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPostDTO;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPutDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoEditarRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.LoginRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.controller.dto.usuario.response.LoginResonseDTO;
import sc.senai.topcare.controller.dto.usuario.response.UsuarioResponseDTO;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.exceptions.UsuarioNaoEncontradoException;
import sc.senai.topcare.repository.ClienteRepository;
import sc.senai.topcare.exceptions.UsuarioExistenteExeption;
import sc.senai.topcare.repository.UsuarioRepository;
import sc.senai.topcare.service.interfaces.EnderecoService;
import sc.senai.topcare.service.interfaces.EspecieService;
import sc.senai.topcare.service.interfaces.PetService;
import sc.senai.topcare.service.interfaces.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final ClienteRepository clientRepository;
    private final UsuarioRepository usuarioRepository;
    private final EspecieService especieService;
    private final EnderecoService enderecoService;
    private final PetService petService;

    @Override
    public ResponseEntity<Cliente> cadastro(ClienteRequestPostDTO usuarioDTO) {
        try{
            if(clientRepository.existsByCpf(usuarioDTO.cpf())){
                throw new UsuarioExistenteExeption("O CPF já existe no sistema!");
            }

            Cliente usuario = new Cliente();
            Endereco endereco = new Endereco();

            BeanUtils.copyProperties(usuarioDTO, usuario);
            BeanUtils.copyProperties(usuarioDTO, endereco);
            endereco.setNome(usuarioDTO.nomeEndereco());

            usuario.setPets(new ArrayList<>());
            usuario.setCartoes(new ArrayList<>());
            usuario.setCupons(new ArrayList<>());
            usuario.setFavoritos(new ArrayList<>());
            usuario.setPedidos(new ArrayList<>());
            usuario.setAgendamentos(new ArrayList<>());

            usuario.getPets().add(usuarioDTO.pet());
            usuario.setEnderecos(List.of(endereco));
            clientRepository.save(usuario);

            return ResponseEntity.ok(usuario);
        }catch (UsuarioExistenteExeption e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<LoginResonseDTO> login(LoginRequestDTO login) {
        try{
            Optional<Usuario> usuario = usuarioRepository.findByEmail(login.email());

            if(usuario.isEmpty() || !usuario.get().getSenha().equals(login.senha())){
                throw new UsuarioNaoEncontradoException();
            }

            return ResponseEntity.ok(new LoginResonseDTO(usuario.get().getId()));
        }catch (UsuarioNaoEncontradoException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> buscarUsuario(Long id) {
        try{
            ModelMapper modelMapper = new ModelMapper();

            Cliente optionalCliente = clientRepository.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);
            UsuarioResponseDTO usuarioResponseDTO = modelMapper.map(optionalCliente, UsuarioResponseDTO.class);

            return ResponseEntity.ok(usuarioResponseDTO);
        }catch (UsuarioNaoEncontradoException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Boolean> cadastrarEndereco(EnderecoRequestDTO enderecoDTO) {
        try{
            Cliente cliente = clientRepository.findById(enderecoDTO.idUsuario()).orElseThrow(UsuarioNaoEncontradoException::new);

            Endereco endereco = new Endereco();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            cliente.getEnderecos().add(endereco);

            clientRepository.save(cliente);
            return ResponseEntity.ok(true);
        }catch (UsuarioNaoEncontradoException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Boolean> cadastrarPet(PetRequestDTO petDTO) {
        try{
            Cliente cliente = clientRepository.findById(petDTO.idUsuario()).orElseThrow(UsuarioNaoEncontradoException::new);

            Pet pet = new Pet();
            BeanUtils.copyProperties(petDTO, pet);
            pet.setEspecie(especieService.buscarEspecie(petDTO.idEspecie()));
            cliente.getPets().add(pet);
            clientRepository.save(cliente);

            return ResponseEntity.ok(true);
        }catch (UsuarioNaoEncontradoException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Boolean> editarEndereco(EnderecoEditarRequestDTO enderecoDTO) {
        Endereco endereco = enderecoService.buscar(enderecoDTO.id());
        BeanUtils.copyProperties(enderecoDTO, endereco);
        enderecoService.salvar(endereco);
        return ResponseEntity.ok(true);
    }

    @Override
    public String deletarEndereco(Long id) {
        return enderecoService.deletar(id);
    }

    @Override
    public Cliente editar(ClienteRequestPutDTO dto, Long id) {
        Cliente cliente = buscarCliente(id);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, cliente);
        return clientRepository.save(cliente);
    }

    @Override
    public Pet editarPet(PetRequestDTO petRequestDTO, Long id) {
        Pet pet = new Pet(petRequestDTO);
        return petService.editarPet(pet);
    }

    public Cliente buscarCliente(Long id){
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}