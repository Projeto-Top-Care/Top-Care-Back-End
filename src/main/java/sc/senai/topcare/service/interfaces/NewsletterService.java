package sc.senai.topcare.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.newsletter.NewsletterDTO;
import sc.senai.topcare.entity.Newsletter;
import sc.senai.topcare.entity.Usuario;

import java.util.List;

@Service
public interface NewsletterService {

    ResponseEntity<Newsletter> subscribe(Long newsletterId, Long usuarioId);

    ResponseEntity<Newsletter> unsubscribe(Long newsletterId, Long usuarioId);

    List<Newsletter> buscarTodasNewletters();

    ResponseEntity<Newsletter> cadastroNewsletter(NewsletterDTO newsletterDTO);
}
