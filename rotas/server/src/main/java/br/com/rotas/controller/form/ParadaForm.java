package br.com.rotas.controller.form;

import br.com.rotas.modelo.Parada;
import br.com.rotas.modelo.Posicao;
import br.com.rotas.modelo.Rota;
import io.jsonwebtoken.lang.Assert;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParadaForm {

    private @NotEmpty String nome;
    private @NotNull PosicaoForm posicaoForm;

    public ParadaForm(String nome, PosicaoForm posicao) {
        this.nome = nome;
        this.posicaoForm = posicao;
    }

    public Parada toModel(@NotNull Rota rota) {
        Assert.notNull(posicaoForm, "Posicao precisa exisitir");
        Assert.notNull(rota, "Uma parada precisa estar associada a uma rota");
        Posicao posicao = posicaoForm.toModel();
        return new Parada(nome, posicao, rota);
    }

    public String getNome() {
        return nome;
    }

    public PosicaoForm getPosicaoForm() {
        return posicaoForm;
    }

}
