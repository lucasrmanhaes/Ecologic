package br.com.ecologic.model;

import br.com.ecologic.constants.TipoResiduo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "TB_RESIDUO")
public class Residuo {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id_residuo")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoResiduo tipoResiduo;

    private Double capacidade;

    private Double volume;

}