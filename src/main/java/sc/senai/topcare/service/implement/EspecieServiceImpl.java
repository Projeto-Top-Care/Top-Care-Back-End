package sc.senai.topcare.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.exceptions.EspecieNaoEncontradaException;
import sc.senai.topcare.repository.EspecieRepository;
import sc.senai.topcare.service.interfaces.EspecieService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EspecieServiceImpl implements EspecieService {

    private final EspecieRepository repository;

    @Override
    public Especie buscarEspecie(Long id) {
        try{
            return repository.findById(id).orElseThrow(EspecieNaoEncontradaException::new);
        }catch (EspecieNaoEncontradaException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
