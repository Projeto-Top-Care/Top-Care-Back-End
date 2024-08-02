package sc.senai.topcare.controller.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoEditarRequestDTO;
import sc.senai.topcare.controller.dto.usuario.request.endereco.EnderecoRequestDTO;
import sc.senai.topcare.service.implement.UsuarioServiceImpl;

@RestController
@RequestMapping("usuario/endereco")
public class UsuarioEnderecoController extends UsuarioController{
    public UsuarioEnderecoController(UsuarioServiceImpl usuarioService) {
        super(usuarioService);
    }
    @PatchMapping("/cadastro")
    public ResponseEntity<Boolean> cadastrarEndereco(@RequestBody EnderecoRequestDTO enderecoDTO){
        return  usuarioService.cadastrarEndereco(enderecoDTO);
    }

    @PutMapping("/editar")
    public ResponseEntity<Boolean> editarEndereco(@RequestBody EnderecoEditarRequestDTO enderecoDTO){
        return usuarioService.editarEndereco(enderecoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.deletarEndereco(id));
    }
}
