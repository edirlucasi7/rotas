package br.com.rotas.controller.form;

import br.com.rotas.modelo.Rota;
import br.com.rotas.modelo.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RotaForm {

    private @NotEmpty String nome;
    private List<ParadaForm> paradas = new ArrayList<>();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private @NotNull LocalDate dataRota;
    private @NotNull Long idVeiculo;
//    private @NotNull String caminhoEncodado;

    public RotaForm(String nome, Long idVeiculo, List<ParadaForm> paradas) {
        this.nome = nome;
        this.idVeiculo = idVeiculo;
        this.paradas.addAll(paradas);
    }

    public Rota toModel(EntityManager manager) {
        Veiculo veiculo = manager.find(Veiculo.class, idVeiculo);
        Assert.state(veiculo!=null, "Uma rota precisa está associada com um veículo!");
        return new Rota(nome, paradas, dataRota, veiculo);
    }

    public List<ParadaForm> getParadas() {
        return paradas;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataRota() {
        return dataRota;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }
}
