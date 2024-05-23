        package br.com.ecologic.dto.residuo_dto;

        import br.com.ecologic.constants.TipoResiduo;
        import jakarta.validation.constraints.NotBlank;

        public record ResiduoCadastroDto(
                @NotBlank(message = "O tipo de resíduo é obrigatório.")
                TipoResiduo tipoResiduo,
                @NotBlank(message = "A capacidade da lixeira é obrigatória.")
                Double capacidade,
                @NotBlank(message = "A quantidade de lixo - 'volume' é obrigatória.")
                Double volume
        ) {}