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
import sc.senai.topcare.entity.*;
import sc.senai.topcare.repository.ServicoRepository;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
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

    private Servico criarServico(){
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        Periodo periodo = new Periodo(1L, LocalTime.now(), LocalTime.now());
        Horario horario = new Horario();
        horario.setId(1L);
        funcionario.setNome("Funcionario");
        funcionario.setCelular("232234234224");
        funcionario.setCpf("223232323");
        funcionario.setEmail("funcionario@gmail.com");
        funcionario.setDataNascimento(LocalDate.of(2020, 1, 1));
        funcionario.setRole(Role.BASIC);
        funcionario.setSenha("asfsdf");
        funcionario.setSexo(Sexo.FEMININO);
        horario.setReservado(false);
        horario.setDia(LocalDate.now());
        horario.setHorarios(List.of(periodo));
        Endereco endereco = new Endereco(1L, "a", "aaa", Estado.SC, "cidade", "bairro", "rua", 123, "aaa");
        funcionario.setFilial(new Filial(1L, "Nome", endereco));
        VarianteServico varianteServico = new VarianteServico(1L, "aaa", "aa", 123.0);
        Especie especie = new Especie();
        especie.setId(1L);
        especie.setNome("Especie");

        Servico servico = new Servico(
                1L,
                "Nome",
                "categoria",
                new File(1L, "Caminho"),
                "descricao",
                List.of(funcionario),
                List.of(especie),
                List.of(varianteServico)
        );
        horario.setServico(servico);
        funcionario.setServicos(List.of(servico));
        especie.setServicos(List.of(servico));
        return servico;
    }

    @Test
    void testeServicoControllerPostOK() throws Exception {
        when(servicoRepository.save(new Servico()))
                .then(invocationOnMock -> criarServico());

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
    void testeServicoControllerGetUmOK() throws Exception {
        when(servicoRepository.findById(1L))
                .then(invocationOnMock -> Optional.of(criarServico()));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/servicos/1"))
                .andExpect(
                        status().isOk()
                ).andExpectAll(
                        jsonPath("$.id").isNumber(),
                        jsonPath("$.imagem").exists(),
                        jsonPath("$.nome").isString(),
                        jsonPath("$.categoria").isString(),
                        jsonPath("$.descricao").isString(),
                        jsonPath("$.funcionarios").isArray(),
                        jsonPath("$.especies").isArray(),
                        jsonPath("$.variantes").isArray(),
                        jsonPath("$.*").exists()
                ).andExpectAll(
                        jsonPath("$.funcionarios").value(Matchers.hasSize(1)),
                        jsonPath("$.funcionarios[0].id").isNumber(),
                        jsonPath("$.funcionarios[0].nome").exists()
                ).andExpectAll(
                        jsonPath("$.especies[0].id").exists(),
                        jsonPath("$.especies[0].nome").exists()
                ).andExpectAll(
                        jsonPath("$.variantes[0].tipo").exists(),
                        jsonPath("$.variantes[0].nome").exists(),
                        jsonPath("$.variantes[0].preco").isNumber()
                );
    }

    @Test
    void testeServicoControllerGetUmNotFound() throws Exception{
        when(servicoRepository.findById(1L)).then(invocationOnMock ->
                Optional.empty()
        );
        mockMvc.perform(MockMvcRequestBuilders.get("/servicos/1")).andExpect(
                status().isNotFound()
        );
    }

    @Test
    void testeServicoControllerGetTodos() throws Exception {
        when(servicoRepository.findAll())
                .then(invocationOnMock -> List.of(criarServico()));

        mockMvc.perform(MockMvcRequestBuilders.get("/servicos")).andExpect(
                status().isNoContent()
        ).andExpect(
                jsonPath("$.*").isArray()
        ).andExpectAll(
                jsonPath("$[0].id").isNumber(),
                jsonPath("$[0].imagem").exists(),
                jsonPath("$[0].nome").isString(),
                jsonPath("$[0].categoria").isString(),
                jsonPath("$[0].descricao").isString(),
                jsonPath("$[0].funcionarios").isArray(),
                jsonPath("$[0].especies").isArray(),
                jsonPath("$[0].variantes").isArray(),
                jsonPath("$[0].*").exists()
        ).andExpectAll(
                jsonPath("$[0].funcionarios").value(Matchers.hasSize(1)),
                jsonPath("$[0].funcionarios[0].id").isNumber(),
                jsonPath("$[0].funcionarios[0].nome").exists()
        ).andExpectAll(
                jsonPath("$[0].especies[0].id").exists(),
                jsonPath("$[0].especies[0].nome").exists()
        ).andExpectAll(
                jsonPath("$[0].variantes[0].tipo").exists(),
                jsonPath("$[0].variantes[0].nome").exists(),
                jsonPath("$[0].variantes[0].*").isNumber()
        );
    }

    @Test
    void testeServicoControllerGetTodosNoContent() throws Exception {
        when(servicoRepository.findAll())
                .then(invocationOnMock -> List.of());

        mockMvc.perform(MockMvcRequestBuilders.get("/servicos"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testeServicoControllerPutOK() throws Exception{
        Servico servico = new Servico();
        when(servicoRepository.save(new Servico())).then(invocationOnMock -> servico);
        when(servicoRepository.findById(1L)).then(invocationOnMock -> servico);

        mockMvc.perform(MockMvcRequestBuilders.put("/servicos/1")
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
                   """))
                .andExpect(status().isOk());
    }

    @Test
    void testeServicoControllerDeleteNoContent() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/servicos/1")
        ).andExpect(status().isNoContent());
    }
    @Test
    void testeServicoControllerDeleteNotFound() throws Exception{
        doThrow(new NullPointerException())
                .when(servicoRepository)
                .deleteById(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/servicos/1")
        ).andExpect(status().isNotFound());
    }

    @Test
    void testeServicoControllerDeleteConflict() throws Exception{
        doThrow(new SQLIntegrityConstraintViolationException())
                .when(servicoRepository)
                .deleteById(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/servicos/1")
        ).andExpect(status().isConflict());
    }

    @Test
    void testeServicoControllerDeleteBadRequest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/servicos/1")
        ).andExpect(status().isBadRequest());
    }

    @Test
    void testeServicoControllerPostConflict() throws Exception{
        when(servicoRepository.save(new Servico()))
                .thenThrow(new SQLIntegrityConstraintViolationException());

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
                   """)).andExpect(status().isConflict());
    }

    @Test
    void testeServicoControllerPostBadRequest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/servicos")
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
                   """))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testeServicoControllerPostInternalServerError() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/servicos")
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
                   """))
                .andExpect(status().isInternalServerError());
    }


}
