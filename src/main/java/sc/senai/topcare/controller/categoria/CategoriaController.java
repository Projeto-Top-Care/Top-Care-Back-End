package sc.senai.topcare.controller.categoria;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sc.senai.topcare.entity.Categoria;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.service.categoria.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("categoria")
@AllArgsConstructor
@CrossOrigin("*")
public class CategoriaController {

    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategoria(){
        try{
            return ResponseEntity.ok(categoriaService.findAll());
        }catch (ListaVaziaException e){
            return ResponseEntity.noContent().build();
        }
    }

}
