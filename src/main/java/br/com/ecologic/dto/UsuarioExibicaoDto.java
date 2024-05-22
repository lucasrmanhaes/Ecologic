package br.com.ecologic.dto;

import br.com.ecologic.model.Usuario;
import java.util.UUID;

public record UsuarioExibicaoDto(
        UUID id,
        String nome,
        String telefone,
        String email
) {
     public UsuarioExibicaoDto(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getEmail()
        );
    }
}
