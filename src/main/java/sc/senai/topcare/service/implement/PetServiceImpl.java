package sc.senai.topcare.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.pet.PetRequestDTO;
import sc.senai.topcare.entity.Cliente;
import sc.senai.topcare.entity.Especie;
import sc.senai.topcare.entity.Pet;
import sc.senai.topcare.repository.PetRepository;
import sc.senai.topcare.service.interfaces.PetService;
import sc.senai.topcare.service.interfaces.UsuarioService;
import sc.senai.topcare.utils.ModelMapperUtil;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository repository;
    private final UsuarioService usuarioService;

    @Override
    public Pet editar(PetRequestDTO petDTO, Long id) {
        Pet pet = new Pet();
        return repository.save(pet);
    }

    @Override
    public void cadastrar(PetRequestDTO dto) {
        Cliente cliente = usuarioService.buscarCliente(dto.getId());
        Pet pet = new Pet();
        ModelMapperUtil.getModelMapper().map(dto, pet);
        pet.setEspecie( new Especie(dto.getIdEspecie()));
        cliente.getPets().add(pet);
        usuarioService.salvar(cliente);
    }
}
