package br.com.ecologic.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "TB_LOCALIZACAO")
public class Localizacao {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id_localizacao")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;

    private double latidade;

    private double longitute;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOcorrencia;
}
