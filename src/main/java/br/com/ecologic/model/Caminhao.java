package br.com.ecologic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "TB_CAMINHAO")
public class Caminhao {

    @Id
    @Column(name = "id_caminhao")
    private UUID id;

    private String placa;

    private String renavam;

}