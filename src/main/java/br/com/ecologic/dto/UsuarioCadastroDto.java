package br.com.ecologic.dto;

import br.com.ecologic.constants.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
        @Size(min = 6, max = 8, message = "A senha ter entre 6 a 8 caracteres")
        String senha,
        @NotBlank(message = "O CEP é obrigatório")
        @Size(min = 8, max = 8, message = "O CEP deve possuir 8 caracteres")
        String cep,
        boolean ativo,
        UsuarioRole role
)
{ }
