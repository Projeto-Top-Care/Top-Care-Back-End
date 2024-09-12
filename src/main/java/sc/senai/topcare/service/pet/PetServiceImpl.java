package sc.senai.topcare.service.pet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.controller.dto.usuario.response.pet.PetServicoResponseDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.repository.PetRepository;
import sc.senai.topcare.service.cliente.ClienteService;
import sc.senai.topcare.utils.ModelMapperUtil;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository repository;
    private final ClienteService clienteService;

    @Override
    public Pet editar(PetRequestDTO petDTO, Long id) {
        Pet pet = buscarPorId(id);
        pet.setEspecie(new Especie(petDTO.getIdEspecie()));
        pet.setNome(petDTO.getNome());
        pet.setRaca(petDTO.getRaca());
        pet.setPorte(petDTO.getPorte());
        return repository.save(pet);
    }

    @Override
    public PetServicoResponseDTO buscarPetServicoPorId(Long id) {
        Pet pet = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return new PetServicoResponseDTO(pet);
    }
    @Override
    public Pet buscarPorId(Long id){
        Pet pet = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return pet;
    }

    @Override
    public void cadastrar(PetRequestDTO dto) {
        Cliente cliente = clienteService.buscarCliente(dto.getIdUsuario());
        Pet pet = new Pet();
        ModelMapperUtil.map(dto, pet);
        pet.setEspecie( new Especie(dto.getIdEspecie()));
        cliente.getPets().add(pet);
        clienteService.salvar(cliente);
    }
}
