package br.com.rotas.controller.form;

import br.com.rotas.modelo.Parada;
import br.com.rotas.modelo.Rota;
import io.jsonwebtoken.lang.Assert;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParadaForm {

    private @NotEmpty String nome;
    private @NotNull PosicaoForm posicao;

    public ParadaForm(String nome, PosicaoForm posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }

    public Parada toModel(@NotNull Rota rota) {
        Assert.notNull(rota, "Uma parada precisa esta associada a uma rota");
        return new Parada(nome, posicao, rota);
    }

    public String getNome() {
        return nome;
    }

    public PosicaoForm getPosicaoForm() {
        return posicao;
    }

}
