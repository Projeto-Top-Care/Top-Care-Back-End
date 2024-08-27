//package sc.senai.topcare.controller.servicos;
//
//import com.jayway.jsonpath.JsonPath;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import sc.senai.topcare.entity.*;
//import sc.senai.topcare.repository.ServicoRepository;
//import sc.senai.topcare.service.servico.ServicoService;
//import sc.senai.topcare.service.servico.ServicoServiceImpl;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@TestPropertySource("classpath:test.application.properties")
//@AutoConfigureMockMvc
//class ServicoControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    ServicoRepository servicoRepository;
//
//    @Test
//    void testServicoControllerCadastro() throws Exception {
//        mockMvc.perform(post("/servicos")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("""
//                        {
//                            "nome": "Banho",
//                            "especie": [],
//                            "categoria": "Banho",
//                            "descricao": "Banho completo",
//                            "funcionarios": [],
//                            "variantes": []
//                        }
//                        """))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    void testeServicoControllerBuscarUm() throws Exception {
//        when(servicoRepository.findById(1L)).then(
//                invocation -> {
//                    Funcionario funcionario = new Funcionario();
//                    funcionario.setId(1L);
//                    funcionario.setNome("Nome Funcionário");
//                    funcionario.setCpf("000.000.000-00");
//                    funcionario.setCelular("(47) 00000-0000");
//                    funcionario.setEmail("funcionario@gmail.com");
//                    funcionario.setSenha("Senha");
//                    funcionario.setDataNascimento(LocalDate.now());
//                    funcionario.setSexo(Sexo.NAO_INFORMAR);
//                    funcionario.setRole(Role.FUNCIONARIO);
//
//                    Endereco endereco = new Endereco(1L, "Endereço", "89000-000", Estado.SC,
//                            "Cidade", "Bairro", "Rua", 123, "Complemento");
//
//                    Filial filial = new Filial(1L, "Nome Filial", endereco);
//                    funcionario.setFilial(filial);
//
//                    Periodo periodo = new Periodo(1L, LocalTime.now(), LocalTime.now());
//
//                    Horario horario = new Horario();
//                    horario.setId(1L);
//                    horario.setReservado(false);
//                    horario.setDia(LocalDate.now());
//                    horario.setHorarios(List.of(periodo));
//                    funcionario.setHorariosAgendados(List.of(horario));
//
//                    Especie especie = new Especie();
//                    especie.setId(1L);
//                    especie.setNome("Nome Especie");
//
//                    VarianteServico variante = new VarianteServico(1L, "Nome Variante",
//                            "Tipo Variante", 100.0);
//
//                    Servico servico = new Servico(1L, "Nome Serviço", "Categoria teste",
//                            new File(1L, "Imagem teste"), "Descrição teste", List.of(funcionario),
//                            List.of(especie), List.of(variante));
//                    horario.setServico(servico);
//                    funcionario.setServicos(List.of(servico));
//                    especie.setServicos(List.of(servico));
//
//                    return Optional.of(servico);
//                }
//        );
//
//        mockMvc.perform(
//                        get("/servicos/1"))
//                .andExpect(status().isOk())
//                .andExpectAll(
//                        jsonPath("$.id").isNumber(),
//                        jsonPath("$.imagem").isString(),
//                        jsonPath("$.nome").isString(),
//                        jsonPath("$.categoria").isString(),
//                        jsonPath("$.descricao").isString(),
//                        jsonPath("$.funcionarios").isArray(),
//                        jsonPath("$.especies").isArray(),
//                        jsonPath("$.variantes").isArray(),
//                        jsonPath("$.*").value(Matchers.hasSize(8))
//                )
//                .andExpectAll(
//                        jsonPath("$.funcionarios[0].id").isNumber(),
//                        jsonPath("$.funcionarios[0].nome").isString(),
//                        jsonPath("$.funcionarios[0].*").value(Matchers.hasSize(2))
//                )
//                .andExpectAll(
//                        jsonPath("$.especies[0].id").isNumber(),
//                        jsonPath("$.especies[0].nome").isString(),
//                        jsonPath("$.especies[0].*").value(Matchers.hasSize(2))
//                )
//                .andExpectAll(
//                        jsonPath("$.variantes[0].nome").isString(),
//                        jsonPath("$.variantes[0].tipo").isString(),
//                        jsonPath("$.variantes[0].preco").isNumber(),
//                        jsonPath("$.variantes[0].*").value(Matchers.hasSize(3))
//                );
//    }
//}