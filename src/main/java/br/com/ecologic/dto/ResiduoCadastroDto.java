package br.com.ecologic.dto;

import br.com.ecologic.constants.TipoResiduo;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record ResiduoCadastroDto(

        @NotBlank(message = "A capacidade da lixeira é obrigatória.")
        Double capacidade,

        @NotBlank(message = "A quantidade de lixo - 'volume' é obrigatória.")
        Double volume,

        @NotBlank(message = "O tipo de resíduo é obrigatório.")
        TipoResiduo tipoResiduo,

        @NotBlank(message = "O ID do usuário é obrigatório")
        UUID idUsuario
) {

}