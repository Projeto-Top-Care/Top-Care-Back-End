package sc.senai.topcare.controller.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.topcare.controller.dto.usuario.request.ClienteRequestPostDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Funcionario;
import sc.senai.topcare.service.factory.FactoryService;

@RestController
@RequestMapping("/factory")
@RequiredArgsConstructor
public class UsuarioFactoryController {

    private final FactoryService service;

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody ClienteRequestPostDTO dto){
        return ResponseEntity.ok(service.criarCliente(dto));
    }
    @PostMapping("/funcionario")
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody FuncionarioRequestDTO dto){
        return ResponseEntity.ok(service.criarFuncionario(dto));
    }
}
