package br.com.ecologic.model;

import br.com.ecologic.constants.TipoResiduo;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity(name = "TB_RESIDUOS")
public class Residuo {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id_residuo")
    private UUID id;
    private Double capacidade;
    private Double volume;

    @Enumerated(EnumType.STRING)
    private TipoResiduo tipoResiduo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;

}