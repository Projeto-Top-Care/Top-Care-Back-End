package sc.senai.topcare.service.filial;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.filial.FilialPostDto;
import sc.senai.topcare.controller.dto.filial.FilialSimplesRequestDTO;
import sc.senai.topcare.entity.Endereco;
import sc.senai.topcare.entity.Filial;
import sc.senai.topcare.exceptions.FiliarNaoEncontradaException;
import sc.senai.topcare.repository.FilialRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FilialServiceImpl implements FilialService {
    FilialRepository filialRepository;

    @Override
    public Boolean cadastro(FilialPostDto filialDto) {
        Endereco endereco = new Endereco(
                filialDto.getNomeEndereco(),
                filialDto.getCep(),
                filialDto.getEstado(),
                filialDto.getCidade(),
                filialDto.getBairro(),
                filialDto.getRua(),
                filialDto.getNumero(),
                filialDto.getComplemento()
        );
        Filial filial = new Filial();
        filial.setEndereco(endereco);
        filial.setNome(filialDto.getNome());
        filialRepository.save(filial);
        return true;
    }

    @Override
    public Filial buscarFiliar(Long id) {
        return filialRepository.findById(id).get();
    }

    @Override
    public List<FilialSimplesRequestDTO> buscarFiliais() {
        List<Filial> filiais = filialRepository.findAll();
        List<FilialSimplesRequestDTO> filialSimplesRequestDTOS = new ArrayList<>();
        filiais.forEach(filial -> {
            filialSimplesRequestDTOS.add(new FilialSimplesRequestDTO(filial.getNome()));
        });
        return filialSimplesRequestDTOS;
    }

    @Override
    public Boolean excluir(Long id) {
        try {
            filialRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public FilialSimplesRequestDTO atualizar(Long id, FilialSimplesRequestDTO filialDto) {
        Filial filial = filialRepository.findById(id).get();
        filial.setNome(filialDto.getNome());
        filialRepository.save(filial);
        return new FilialSimplesRequestDTO(filial.getNome());
    }
}
