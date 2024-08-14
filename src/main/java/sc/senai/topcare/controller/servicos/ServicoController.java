package sc.senai.topcare.controller.servicos;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/servicos")
@RequiredArgsConstructor
public class ServicoController {
    @PostMapping
    public void cadastrar(){

    }

}
