package sc.senai.topcare.service.interfaces;

import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.Newsletter;
import sc.senai.topcare.entity.Usuario;

import java.util.List;

@Service
public interface NewsletterService {

    Usuario subscribe(Long id);
    List<Newsletter> buscarTodasNewletters();
}
