package br.com.rotas.modelo;

import br.com.rotas.controller.form.ParadaForm;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Rota {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotEmpty String nome;
    @OneToMany(mappedBy = "rota", cascade = CascadeType.PERSIST)
    private @NotNull List<Parada> paradas = new ArrayList<>();
    private @NotNull LocalDate dataRota;
    @ManyToOne
    private @NotNull Veiculo veiculo;
    //    private @NotNull String caminhoEncodado;

    @Deprecated
    public Rota() { }

    public Rota(String nome, List<ParadaForm> paradas, LocalDate dataRota, Veiculo veiculo) {
        this.nome = nome;
        this.dataRota = dataRota;
        this.veiculo = veiculo;
        this.paradas.addAll(paradas.stream().map(parada -> parada.toModel(this)).collect(Collectors.toSet()));
    }

    public String getNome() {
        return nome;
    }

    public List<Parada> getParadas() {
        return paradas;
    }

//    public String getCaminhoEncodado() {
//        return caminhoEncodado;
//    }

    public LocalDate getDataRota() {
        return dataRota;
    }

    public Long getId() {
        return id;
    }

    public Veiculo getIdVeiculo() {
        return veiculo;
    }
}
