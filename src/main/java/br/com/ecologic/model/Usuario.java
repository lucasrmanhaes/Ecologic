package br.com.ecologic.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@Entity(name = "TB_USUARIO")
public class Usuario {

    @Id @GeneratedValue(generator = "UUID") @Column(name = "id_usuario")
    private UUID id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private boolean ativo = true;
}
