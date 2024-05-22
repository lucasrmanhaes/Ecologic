package br.com.ecologic.service;

import br.com.ecologic.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${key.auth}")
    private String chaveSecreta;

    public Instant gerarDataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String gerarToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);
            return JWT.create().withIssuer("ecologic").withSubject(usuario.getEmail())
            .withExpiresAt(gerarDataExpiracao()).sign(algorithm);
        }
        catch(JWTCreationException erro){
            throw new RuntimeException("Não foi possível gerar o token JWT");
        }
    }

    public String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);
            return JWT.require(algorithm).withIssuer("ecologic").build().verify(token).getSubject(); //Retornar e-mail
        }
        catch(JWTVerificationException erro){
            throw new RuntimeException("Não foi possível validar o token");
        }
    }

}
