package br.com.rotas.controller.dto;

import br.com.rotas.modelo.Parada;
import br.com.rotas.modelo.Rota;
import br.com.rotas.modelo.Veiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RotaDto {

    private String nome;
    private List<Parada> paradas = new ArrayList<>();
    private LocalDate dataRota;
    private Veiculo veiculo;

    public RotaDto(Rota rota) {
        this.nome = rota.getNome();
        this.paradas = rota.getParadas();
        this.dataRota = rota.getDataRota();
        this.veiculo = rota.getIdVeiculo();
    }

    public String getNome() {
        return nome;
    }

    public List<Parada> getParadas() {
        return paradas;
    }

    public LocalDate getDataRota() {
        return dataRota;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

}
