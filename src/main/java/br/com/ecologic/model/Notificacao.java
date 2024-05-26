package br.com.ecologic.model;

import br.com.ecologic.constants.TipoResiduo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "TB_NOTIFICACAO")
public class Notificacao {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id_notificacao")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String titulo;

    private String mensagem;

    public Notificacao criarNotificacao(Usuario usuario, String titulo, String mensagem) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.mensagem = mensagem;
        return this;
    }


}
