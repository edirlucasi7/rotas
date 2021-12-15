package br.com.rotas.controller.form;

import br.com.rotas.modelo.Veiculo;

import javax.validation.constraints.NotEmpty;

public class VeiculoForm {

    private @NotEmpty String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Veiculo toModel() {
        return new Veiculo(nome);
    }

}
