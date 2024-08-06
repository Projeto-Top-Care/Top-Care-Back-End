package sc.senai.topcare.controller.dto.produto;

import jakarta.persistence.OneToMany;
import sc.senai.topcare.entity.Usuario;

import java.util.List;

public class NewsletterRequestDTO {
    private Long id;
    private String texto;
    private List<Usuario> subscribers;
}
