package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.LoginRequestDTO;
<<<<<<< HEAD
=======
import sc.senai.topcare.controller.dto.usuario.LoginResonseDTO;
>>>>>>> 5d089df4c418d9d4c3758d95b735a215c2825090
import sc.senai.topcare.entity.Endereco;
import sc.senai.topcare.exceptions.UsuarioNaoEncontradoException;
import sc.senai.topcare.repository.ClienteRepository;
import sc.senai.topcare.controller.dto.usuario.ClienteRequestPostDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Usuario;
import sc.senai.topcare.exceptions.UsuarioExistenteExeption;
import sc.senai.topcare.repository.UsuarioRepository;
import sc.senai.topcare.service.interfaces.UsuarioService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final ClienteRepository clientRepository;
    private final UsuarioRepository usuarioRepository;
    @Override
    public ResponseEntity<Cliente> cadastro(ClienteRequestPostDTO usuarioDTO) {
        try{

            if(clientRepository.existsByCpf(usuarioDTO.cpf()) || clientRepository.existsByEmail(usuarioDTO.email())){
                throw new UsuarioExistenteExeption("O Cliente já existe no sistema!");
            }

            Cliente usuario = new Cliente();
            Endereco endereco = new Endereco();
<<<<<<< HEAD
            usuario.setEnderecos(new ArrayList<>());
            usuario.setPets(new ArrayList<>());
=======
>>>>>>> 5d089df4c418d9d4c3758d95b735a215c2825090

            BeanUtils.copyProperties(usuarioDTO, endereco);
            BeanUtils.copyProperties(usuarioDTO, usuario);
<<<<<<< HEAD


            endereco.setNome(usuarioDTO.nomeEndereco());
            usuario.getEnderecos().add(endereco);
            usuario.getPets().add(usuarioDTO.pet());

=======
            BeanUtils.copyProperties(usuarioDTO, endereco);
            endereco.setNome(usuarioDTO.nomeEndereco());

            usuario.setPets(new ArrayList<>());
            usuario.getPets().add(usuarioDTO.pet());
            usuario.setEnderecos(List.of(endereco));
>>>>>>> 5d089df4c418d9d4c3758d95b735a215c2825090
            clientRepository.save(usuario);

            return ResponseEntity.ok(usuario);
        }catch (UsuarioExistenteExeption e){
            System.out.println(e.getMessage());
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
}
