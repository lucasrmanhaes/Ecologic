package br.com.ecologic.model;


import br.com.ecologic.constants.TipoResiduo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity(name = "TB_AGENDAMENTO")
public class Agendamento {

    @Id
    @Column(name = "id_agendamento")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoResiduo tipoResiduo;

    @ManyToOne
    @JoinColumn(name = "id_caminhao")
    private Caminhao caminhao;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAgendamento;

    private String status;

}
