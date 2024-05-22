package br.com.ecologic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "TB_CAMINHAO")
public class Caminhao {

    @Id
    @Column(name = "id_caminhao")
    private int id;

    private String placa;

    private String renavam;

}