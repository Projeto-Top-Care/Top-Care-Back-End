package sc.senai.topcare.service.imagem;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sc.senai.topcare.entity.Imagem;

@Service
public interface ImagemService {
    Imagem salvarImagem(MultipartFile multipartFile);
    Imagem getImagem(Long id);
    void deletarImagem(Long id);
    void deletarImagem(String caminho);
}
