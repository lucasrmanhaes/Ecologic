package br.com.ecologic.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pontos {
    private String latitude;
    private String longitude;

    public Pontos(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Pontos(double v, double v1) {
        this.latitude = Double.toString(v);
        this.longitude = Double.toString(v1);
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

}
