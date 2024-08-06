package sc.senai.topcare.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.repository.PetRepository;
import sc.senai.topcare.service.interfaces.PetService;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository repository;

    @Override
    public Pet editarPet(PetRequestDTO petDTO, Long id) {
        Pet pet = new Pet();


        return repository.save(pet);
    }
}
