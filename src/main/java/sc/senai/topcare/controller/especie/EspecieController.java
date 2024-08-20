package sc.senai.topcare.controller.especie;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.service.especie.EspecieService;
import sc.senai.topcare.service.especie.EspecieServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/especie")
@CrossOrigin("*")
@RequiredArgsConstructor
public class EspecieController {

    private final EspecieServiceImpl service;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> buscarTodos(){
        try{
            return ResponseEntity.ok(service.buscarTodos());
        }catch(ListaVaziaException e){
            return ResponseEntity.noContent().build();
        }
    }

}
