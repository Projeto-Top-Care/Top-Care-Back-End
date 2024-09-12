package sc.senai.topcare.service.especie;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.conjuntas.IdNomeResponseDTO;
import sc.senai.topcare.controller.dto.funcionario.FuncionarioResponseDTO;
import sc.senai.topcare.exceptions.ListaVaziaException;
import sc.senai.topcare.repository.EspecieRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EspecieServiceImpl implements EspecieService{

    private EspecieRepository repository;

    @Override
    public List<IdNomeResponseDTO> buscarTodos() throws ListaVaziaException {
        List<IdNomeResponseDTO> especies = repository.findAll().stream().map(IdNomeResponseDTO::new).toList();
        if(especies.isEmpty()){
            throw new ListaVaziaException();
        }
        return especies;
    }
}
