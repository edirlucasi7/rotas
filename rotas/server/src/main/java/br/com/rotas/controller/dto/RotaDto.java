package br.com.rotas.controller.dto;

import br.com.rotas.modelo.Parada;
import br.com.rotas.modelo.Rota;
import br.com.rotas.modelo.Veiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RotaDto {

    private String nome;
    private String origem;
    private String destino;
    private List<Parada> paradas = new ArrayList<>();
    private LocalDate dataRota;
    private Veiculo veiculo;
    private String caminhoEncodado;

    public RotaDto(Rota rota) {
        this.nome = rota.getNome();
        this.origem = rota.getOrigem();
        this.destino = rota.getDestino();
        this.paradas = rota.getParadas();
        this.dataRota = rota.getDataRota();
        this.veiculo = rota.getIdVeiculo();
        this.caminhoEncodado = rota.getCaminhoEncodado();
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

    public String getCaminhoEncodado() {
        return caminhoEncodado;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

}
