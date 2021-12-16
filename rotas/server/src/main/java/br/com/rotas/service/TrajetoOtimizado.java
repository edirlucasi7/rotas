package br.com.rotas.service;

import br.com.rotas.controller.form.ParadaForm;
import br.com.rotas.modelo.Parada;

import java.io.IOException;
import java.util.List;

public interface TrajetoOtimizado {

    List<Integer> organiza(List<Parada> paradas, String origem, String destino) throws IOException;
    String encodeCaminho(List<ParadaForm> paradas);

}
