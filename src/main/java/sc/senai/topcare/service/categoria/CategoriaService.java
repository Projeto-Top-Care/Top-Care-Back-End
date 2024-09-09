package sc.senai.topcare.service.categoria;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.Categoria;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.CategoriaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository repository;

    public List<Categoria> findAll() throws ListaVaziaException {
        List<Categoria> categorias = repository.findAll();
        if(categorias.isEmpty()){
            throw new ListaVaziaException();
        }
        return categorias;
    }
}
