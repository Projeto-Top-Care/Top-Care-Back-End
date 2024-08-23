package sc.senai.topcare.service.servico;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sc.senai.topcare.controller.servicos.ServicoController;
import sc.senai.topcare.entity.*;
import sc.senai.topcare.repository.ServicoRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource("classpath:test.properties")
@AutoConfigureMockMvc
public class ServicoControllerTeste {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ServicoRepository servicoRepository;

    @Test
    void testeServicoControllerCadastro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/servicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                        "nome": "banho",
                        "especies": [],
                        "categoria": "categoria",
                        "descricao": "descricao",
                        "funcionarios": [],
                        "variantes": []
                    }
                   """)).andExpect(status().isCreated());

    }

    @Test
    void testeServicoControllerGetUm() throws Exception {
        Funcionario funcionario = new Funcionario();
        Horario horario = new Horario();
        Endereco endereco = new Endereco();
        Filial filial = new Filial();
        Especie especie = new Especie();

        mockMvc.perform(MockMvcRequestBuilders
                .post("/servicos/1"))
                .andExpectAll(status()
                        .isOk(),
                        jsonPath("$.id").isNumber(),
                        jsonPath("$.imagem").exists(),
                        jsonPath("$.nome").isString(),
                        jsonPath("$.categoria").exists(),
                        jsonPath("$.descricao").exists(),
                        jsonPath("$.funcionarios").isArray(),
                        jsonPath("$.especies").isArray(),
                        jsonPath("$.variantes").isArray(),
                        jsonPath("$.funcionarios[0].id").isNumber(),
                        jsonPath("$.funcionarios[0].nome").isString(),
                        jsonPath("$.funcionarios[0].*").exists(),
                        jsonPath("$.especies[0].id").exists(),
                        jsonPath("$.especies[0].nome").isString(),
                        jsonPath("$.especies[0].*").exists(),
                        jsonPath("$.variantes[0].id").isNumber(),
                        jsonPath("$.variantes[0].nome").isString(),
                        jsonPath("$.variantes[0].*").value(Matchers.hasSize(2)));
    }

}
