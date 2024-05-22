package br.com.ecologic.controller;

import br.com.ecologic.dto.TokenDto;
import br.com.ecologic.dto.UsuarioLoginDto;
import br.com.ecologic.model.Usuario;
import br.com.ecologic.service.TokenService;
import br.com.ecologic.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto){
        UsernamePasswordAuthenticationToken usernamepassword = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.email(),
                usuarioLoginDto.senha()
        );
        Authentication auth = authenticationManager.authenticate(usernamepassword);
        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDto(token));
    }

}
