package br.com.ecologic.dto;

import br.com.ecologic.constants.TipoResiduo;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record AgendamentoDto(
        @NotNull(message = "O ID do usuário é obrigatório.")
        UUID usuarioId,
        @NotNull(message = "O tipo de resíduo é obrigatório.")
        TipoResiduo tipoResiduo,
        @NotNull(message = "O ID do caminhão é obrigatório.")
        UUID caminhaoId,
        @NotNull(message = "A data do agendamento é obrigatória.")
        Date dataAgendamento,

        String status
) {}
