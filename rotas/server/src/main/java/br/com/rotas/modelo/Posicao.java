package br.com.rotas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Posicao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotNull String latitude;
    private @NotNull String longitude;

    @Deprecated
    public Posicao() { }

    public Posicao(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

}
