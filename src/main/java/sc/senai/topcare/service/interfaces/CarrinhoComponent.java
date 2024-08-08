package sc.senai.topcare.service.interfaces;
import org.springframework.stereotype.Service;
import sc.senai.topcare.entity.CarrinhoEx;

@Service
public interface CarrinhoComponent {
        double getPreco(Long id) throws Exception;

}
