package sc.senai.topcare.controller.funcionario;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.service.funcionario.FuncionarioService;
import sc.senai.topcare.service.funcionario.FuncionarioServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@CrossOrigin("*")
@AllArgsConstructor
public class FuncionarioController {

    private FuncionarioServiceImpl service;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> buscarTodos(){
        try{
            return ResponseEntity.ok(service.buscarTodos());
        }catch(ListaVaziaException e){
            return ResponseEntity.noContent().build();
        }
    }
}
