package br.com.rotas.modelo;

import br.com.rotas.controller.form.ParadaForm;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotEmpty String nome;
    private @NotEmpty String origem;
    private @NotEmpty String destino;
    @OneToMany(mappedBy = "rota", cascade = CascadeType.ALL)
    private @NotNull List<Parada> paradas = new ArrayList<>();
    private @NotNull LocalDate dataRota;
    @ManyToOne
    private @NotNull Veiculo veiculo;
    @Lob
    private String caminhoEncodado;

    @Deprecated
    public Rota() {
    }

    public Rota(String nome, String origem, String destino, List<ParadaForm> paradas, LocalDate dataRota, Veiculo veiculo) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.dataRota = dataRota;
        this.veiculo = veiculo;
        this.paradas.addAll(paradas.stream().map(parada -> parada.toModel(this)).collect(Collectors.toSet()));
    }

    public void adicionaParada(@NotNull ParadaForm novaParada) {
        Parada parada = novaParada.toModel(this);
        this.paradas.add(parada);
    }

    public String getNome() {
        return nome;
    }

    @JsonManagedReference
    public List<Parada> getParadas() {
        return paradas;
    }

    public LocalDate getDataRota() {
        return dataRota;
    }

    public Long getId() {
        return id;
    }

    public void setCaminhoEncodado(String caminhoEncodado) {
        this.caminhoEncodado = caminhoEncodado;
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

    public Veiculo getVeiculo() {
        return veiculo;
    }

}
