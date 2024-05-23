package br.com.ecologic.dto;

import br.com.ecologic.constants.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioCadastroDto(
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotBlank(message = "O CPF é obrigatório")
        String cpf,
        @NotBlank(message = "O telefone é obrigatório")
        String telefone,
        @NotBlank(message = "O e-mail é obrigatório")
        @Email(message = "O e-mail está incorreto")
        String email,
        @NotBlank(message = "A senha é obrigatória")
        String senha,
        boolean ativo,
        UsuarioRole role
)
{ }
