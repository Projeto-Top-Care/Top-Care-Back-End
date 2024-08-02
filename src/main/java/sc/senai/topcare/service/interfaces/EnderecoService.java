package sc.senai.topcare.service.interfaces;

import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.entity.Endereco;

@Service
public interface EnderecoService {
    Endereco cadastrar(EnderecoRequestDTO enderecoDTO);
    Endereco buscar(Long id);
    void salvar(Endereco endereco);
    String deletar(Long id);

}
