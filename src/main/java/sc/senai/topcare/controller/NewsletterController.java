package sc.senai.topcare.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.newsletter.NewsletterDTO;
import sc.senai.topcare.entity.Newsletter;
import sc.senai.topcare.service.implement.NewsletterServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/newsletter")
@AllArgsConstructor
public class NewsletterController {

    private final NewsletterServiceImpl newsletterService;

    @GetMapping
    public ResponseEntity<List<Newsletter>> buscarTodasNewsletters() {
        List<Newsletter> newsletters = newsletterService.buscarTodasNewletters();
        return ResponseEntity.ok(newsletters);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Newsletter> cadastroNewsletters(@RequestBody NewsletterDTO newsletterDTO) {
        return newsletterService.cadastroNewsletter(newsletterDTO);
    }

    @PostMapping("/{newsletterId}/subscribe/{usuarioId}")
    public ResponseEntity<Newsletter> subscribe(@PathVariable Long newsletterId, @PathVariable Long usuarioId) {
        return newsletterService.subscribe(newsletterId, usuarioId);
    }

    @PostMapping("/{newsletterId}/unsubscribe/{usuarioId}")
    public ResponseEntity<Newsletter> unsubscribe(@PathVariable Long newsletterId, @PathVariable Long usuarioId) {
        return newsletterService.unsubscribe(newsletterId, usuarioId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Newsletter> atualizarNewsletter(@PathVariable Long id, @RequestBody NewsletterDTO newsletterDTO) {
        return newsletterService.atualizarNewsletter(id, newsletterDTO);
    }
}
