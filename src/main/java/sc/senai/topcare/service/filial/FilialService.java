package sc.senai.topcare.service.filial;

import sc.senai.topcare.controller.dto.filial.FilialPostDto;
import sc.senai.topcare.controller.dto.filial.FilialSimplesRequestDTO;
import sc.senai.topcare.entity.Filial;

import java.util.List;

public interface FilialService {
    Boolean cadastro(FilialPostDto filialDto);
    Filial buscarFiliar(Long id);
    List<FilialSimplesRequestDTO> buscarFiliais();
    Boolean excluir(Long id);
    FilialSimplesRequestDTO atualizar(Long id, FilialSimplesRequestDTO filialDto);

}
