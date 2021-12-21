package br.com.rotas.controller.form;

import br.com.rotas.compartilhado.ExistsId;
import br.com.rotas.compartilhado.UniqueValue;
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

    @UniqueValue(domainClass = Rota.class, fieldName = "nome")
    private @NotEmpty String nome;
    private @NotEmpty String origem;
    private @NotEmpty String destino;
    private List<ParadaForm> paradas = new ArrayList<>();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private @NotNull LocalDate dataRota;
    @ExistsId(domainClass = Veiculo.class, fieldName = "id")
    private @NotNull Long idVeiculo;

    public RotaForm(String nome, String origem, String destino, Long idVeiculo, List<ParadaForm> paradas) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.idVeiculo = idVeiculo;
        this.paradas.addAll(paradas);
    }

    public Rota toModel(EntityManager manager, String caminhoEncodado) {
        Veiculo veiculo = manager.find(Veiculo.class, idVeiculo);
        Assert.state(veiculo!=null, "Uma rota precisa está associada com um veículo!");
        Rota rota = new Rota(nome, origem, destino, paradas, dataRota, veiculo);
        rota.setCaminhoEncodado(caminhoEncodado);
        return rota;
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

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

}
