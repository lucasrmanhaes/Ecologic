package br.com.ecologic.dto;

import br.com.ecologic.constants.TipoResiduo;
import br.com.ecologic.model.Residuo;
import java.util.UUID;

public record ResiduoExibicaoDto(
        UUID id,
        Double capacidade,
        Double volume,
        TipoResiduo tipoResiduo,
        UUID idUsuario,
        String nomeUsuario,
        String emailUsuario
) {
    public ResiduoExibicaoDto(Residuo residuo){
        this(
                residuo.getId(),
                residuo.getCapacidade(),
                residuo.getVolume(),
                residuo.getTipoResiduo(),
                residuo.getUsuario().getId(),
                residuo.getUsuario().getNome(),
                residuo.getUsuario().getEmail()
        );
    }
}
