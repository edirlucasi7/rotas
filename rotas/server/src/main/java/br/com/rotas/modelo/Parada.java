package br.com.rotas.modelo;

import br.com.rotas.controller.form.PosicaoForm;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Parada {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotEmpty String nome;
    @OneToOne(cascade = CascadeType.PERSIST)
    private @NotNull Posicao posicao;
    @ManyToOne
    private @NotNull Rota rota;

    @Deprecated
    public Parada() { }

    public Parada(String nome, PosicaoForm posicaoForm, Rota rota) {
        this.nome = nome;
        this.posicao = posicaoForm.toModel();
        this.rota = rota;
    }

    public String getNome() {
        return nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    @JsonBackReference
    public Rota getRota() {
        return rota;
    }
}
