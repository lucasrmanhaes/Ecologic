package br.com.ecologic.model;

import br.com.ecologic.constants.TipoResiduo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "TB_NOTIFICACAO")
public class Notificacao {

    @Id
    @Column(name = "id_notificacao")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String titulo;

    private String mensagem;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Notificacao criarNotificacao(Usuario usuario, TipoResiduo tipoResiduo) {
        this.usuario = usuario;
        this.mensagem = "Prezado(a), o status do seu ";
        return this;
    }
}
