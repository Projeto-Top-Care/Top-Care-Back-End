package sc.senai.topcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Newsletter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    @ManyToMany
    @JoinTable(name = "newsletter_subscribers",
            joinColumns = @JoinColumn(name = "newsletter_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> subscribers = new ArrayList<>();

    public void addSubscriber(Usuario usuario) {
        subscribers.add(usuario);
    }

    public void removeSubscriber(Usuario usuario) {
        subscribers.remove(usuario);
    }

}
