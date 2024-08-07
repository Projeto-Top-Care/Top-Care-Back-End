package sc.senai.topcare.controller.dto.newsletter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sc.senai.topcare.entity.Usuario;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsletterDTO {
    private Long id;
    private String texto;
    private List<Usuario> subscribers;
}
