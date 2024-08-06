package sc.senai.topcare.service.implement;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sc.senai.topcare.controller.dto.produto.NewsletterRequestDTO;
import sc.senai.topcare.entity.Newsletter;
import sc.senai.topcare.entity.Usuario;
import sc.senai.topcare.repository.NewsletterRepository;
import sc.senai.topcare.service.interfaces.NewsletterService;

import java.util.List;

public class NewsletterServiceImpl implements NewsletterService {

    private NewsletterRepository newsletterRepository;

    @Override
    public Usuario subscribe(Long id) {
        return null;
    }

    public List<Newsletter> buscarTodasNewletters() {
        return newsletterRepository.findAll();
    }

    public ResponseEntity<Newsletter> cadastroNewsletter(NewsletterRequestDTO newsletterRequestDTO) {
        Newsletter newsletter = new Newsletter();
        Newsletter savedNewsletter = newsletterRepository.save(newsletter);
        return new ResponseEntity<>(savedNewsletter, HttpStatus.CREATED);
    }


}
