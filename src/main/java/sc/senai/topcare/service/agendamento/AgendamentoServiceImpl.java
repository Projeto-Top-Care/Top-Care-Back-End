package sc.senai.topcare.service.agendamento;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sc.senai.topcare.repository.AgendamentoRepository;

@Service
@AllArgsConstructor
public class AgendamentoServiceImpl implements AgendamentoService{

    private final AgendamentoRepository repository;


}
