package br.com.ecologic.model;

import br.com.ecologic.constants.TipoResiduo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "TB_RESIDUO")
public class Residuo {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id_residuo")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoResiduo tipoResiduo;

    private Double capacidade;

    private Double volume;

    public Residuo(TipoResiduo tipoResiduo, Double capacidade, Double volume) {
        this.tipoResiduo = tipoResiduo;
        this.capacidade = capacidade;
        this.volume = volume;
    }

    public Residuo() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoResiduo getTipoResiduo() {
        return tipoResiduo;
    }

    public void setTipoResiduo(TipoResiduo tipoResiduo) {
        this.tipoResiduo = tipoResiduo;
    }

    public Double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Double capacidade) {
        this.capacidade = capacidade;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
}