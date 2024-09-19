package sc.senai.topcare.components;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import sc.senai.topcare.entity.Usuario;
import sc.senai.topcare.enuns.Role;
import sc.senai.topcare.enuns.Sexo;
import sc.senai.topcare.repository.ServicoRepository;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class ServicosComponent {
    private ServicoRepository repository;

//    @PostConstruct
//    private void criarUsuarioAdmin(){
//        boolean exist = repository.existsByNome("admin");
//
//        if(!exist){
//            Usuario usuario = Usuario.builder()
//                    .nome("admin")
//                    .senha("usuarioAdmin@321")
//                    .role(Role.ADMIN)
//                    .sexo(Sexo.MASCULINO)
//                    .dataNascimento(LocalDate.of(1990, 10, 24))
//                    .email("administrador@gmail.com")
//                    .cpf("121.222.431.34")
//                    .build();
//            repository.save(usuario);
//        }
//    }
}
