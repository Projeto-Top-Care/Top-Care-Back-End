package sc.senai.topcare.controller.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoEditarRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.service.endereco.EnderecoServiceImpl;

@RestController
@RequestMapping("usuario/endereco")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsuarioEnderecoController{
    private final EnderecoServiceImpl service;
    @PatchMapping("/cadastro")
    public ResponseEntity<Void> cadastrarEndereco(@RequestBody EnderecoRequestDTO enderecoDTO){
        service.cadastrar(enderecoDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Boolean> editar(@RequestBody EnderecoEditarRequestDTO enderecoDTO,
                                          @PathVariable Long id){
        service.editar(enderecoDTO, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        return ResponseEntity.ok(service.deletar(id));
    }
}
