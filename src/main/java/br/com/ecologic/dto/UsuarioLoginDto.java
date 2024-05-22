package br.com.ecologic.dto;

import br.com.ecologic.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioLoginDto(
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "O e-mail está incorreto")
        String email,
        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 6, max = 20, message = "A senha deve conter entre 6 e 20 caracteres")
        String senha
) {
    UsuarioLoginDto(Usuario usuario){
        this(
                usuario.getEmail(),
                usuario.getSenha()
        );
    }
}
