package sc.senai.topcare.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sc.senai.topcare.controller.dto.newsletter.NewsletterDTO;
import sc.senai.topcare.entity.Newsletter;
import sc.senai.topcare.entity.Usuario;
import sc.senai.topcare.repository.NewsletterRepository;
import sc.senai.topcare.repository.UsuarioRepository;
import sc.senai.topcare.service.interfaces.NewsletterService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsletterServiceImpl implements NewsletterService {

    private final NewsletterRepository newsletterRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<Newsletter> subscribe(Long newsletterId, Long usuarioId) {
        Newsletter newsletter = newsletterRepository.findById(newsletterId).orElse(null);
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (newsletter == null || usuario == null) {
            return ResponseEntity.notFound().build();
        }

        newsletter.addSubscriber(usuario);
        newsletterRepository.save(newsletter);
        return ResponseEntity.ok(newsletter);
    }

    @Override
    public ResponseEntity<Newsletter> unsubscribe(Long newsletterId, Long usuarioId) {
        Newsletter newsletter = newsletterRepository.findById(newsletterId).orElse(null);
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (newsletter == null || usuario == null) {
            return ResponseEntity.notFound().build();
        }

        newsletter.removeSubscriber(usuario);
        newsletterRepository.save(newsletter);
        return ResponseEntity.ok(newsletter);
    }

    @Override
    public List<Newsletter> buscarTodasNewletters() {
        return newsletterRepository.findAll();
    }

    @Override
    public ResponseEntity<Newsletter> cadastroNewsletter(NewsletterDTO newsletterDTO) {
        Newsletter newsletter = new Newsletter();
        newsletter.setTexto(newsletterDTO.getTexto());
        newsletter.setSubscribers(newsletterDTO.getSubscribers());
        Newsletter savedNewsletter = newsletterRepository.save(newsletter);
        return ResponseEntity.ok(savedNewsletter);
    }

    public ResponseEntity<Newsletter> atualizarNewsletter(Long id, NewsletterDTO newsletterDTO) {
        Optional<Newsletter> optionalNewsletter = newsletterRepository.findById(id);
        if (optionalNewsletter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Newsletter newsletter = optionalNewsletter.get();
        newsletter.setTexto(newsletterDTO.getTexto());

        // Salva as atualizações
        newsletterRepository.save(newsletter);

        // Notifica os assinantes
        for (Usuario subscriber : newsletter.getSubscribers()) {
            subscriber.update(newsletter.getTexto());
        }

        return ResponseEntity.ok(newsletter);
    }
}
