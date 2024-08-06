package sc.senai.topcare.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.produto.NewsletterRequestDTO;
import sc.senai.topcare.controller.dto.produto.ProdutoRequestDTO;
import sc.senai.topcare.entity.Newsletter;

import sc.senai.topcare.entity.Produto;
import sc.senai.topcare.service.implement.NewsletterServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/newsletter")
@AllArgsConstructor
@NoArgsConstructor
public class NewsletterController {

    private NewsletterServiceImpl newsletterService;
    private NewsletterRequestDTO newsletterRequestDTO;
    @GetMapping
    public ResponseEntity<List<Newsletter>> buscarTodasNewsletters() {
        List<Newsletter> newsletters = newsletterService.buscarTodasNewletters();
        return ResponseEntity.ok(newsletters);
    }
    @PostMapping("/adicionar")
    public ResponseEntity<Newsletter> cadastroNewsletters(@RequestBody NewsletterRequestDTO newsletterRequestDTO) {
        return newsletterService.cadastroNewsletter(newsletterRequestDTO);
    }
}
