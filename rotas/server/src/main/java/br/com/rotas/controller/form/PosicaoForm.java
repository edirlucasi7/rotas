package br.com.rotas.controller.form;

import br.com.rotas.modelo.Posicao;
import org.springframework.security.core.parameters.P;

import javax.validation.constraints.NotNull;

public class PosicaoForm {

    private @NotNull String latitude;
    private @NotNull String longitude;

    public PosicaoForm(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Posicao toModel() {
        return new Posicao(latitude, longitude);
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

}
