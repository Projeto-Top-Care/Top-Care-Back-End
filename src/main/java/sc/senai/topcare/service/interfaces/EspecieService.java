package sc.senai.topcare.service.interfaces;

import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.Especie;

@Service
public interface EspecieService {
    Especie buscarEspecie(Long id);
}
