package br.com.rotas.service;

import br.com.rotas.controller.form.ParadaForm;
import br.com.rotas.modelo.Parada;

import java.io.IOException;
import java.util.List;

public interface OtimizaRota {

    List<Integer> organizaCaminho(List<Parada> paradas, String origem, String destino) throws IOException;
    String encodaCaminho(List<ParadaForm> paradas, String origem, String destino);

}
