package sc.senai.topcare.service.interfaces;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.entity.Pet;

@Service
public interface PetService {
    void cadastrar(PetRequestDTO dto);
    Pet editar(PetRequestDTO petDTO, Long id);

    Pet buscarPorId(Long id);
}
