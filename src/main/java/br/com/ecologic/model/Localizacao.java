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

    private String latidade;

    private String longitute;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataOcorrencia;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public String getLatidade() {
        return latidade;
    }

    public void setLatidade(String latidade) {
        this.latidade = latidade;
    }

    public String getLongitute() {
        return longitute;
    }

    public void setLongitute(String longitute) {
        this.longitute = longitute;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }
}
