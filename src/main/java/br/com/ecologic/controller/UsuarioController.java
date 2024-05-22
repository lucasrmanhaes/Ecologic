package br.com.ecologic.controller;

import br.com.ecologic.dto.UsuarioCadastroDto;
import br.com.ecologic.dto.UsuarioExibicaoDto;
import br.com.ecologic.model.Usuario;
import br.com.ecologic.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto gravar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto){
        return usuarioService.gravar(usuarioCadastroDto);
    }

    @GetMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto buscarPorId(@PathVariable("id") UUID id){
        return usuarioService.BuscarPorId(id);
    }

    @PutMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioExibicaoDto atualizar(@RequestBody Usuario usuario){
        return usuarioService.atualizar(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void desativar(@PathVariable("id") UUID id){
        usuarioService.desativar(id);
    }

}
