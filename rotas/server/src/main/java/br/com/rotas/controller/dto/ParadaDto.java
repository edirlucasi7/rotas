package br.com.rotas.controller.dto;

import br.com.rotas.modelo.Parada;
import br.com.rotas.modelo.Posicao;

public class ParadaDto {

    private String nome;
    private Posicao posicao;

    public ParadaDto(Parada parada) {
        this.nome = parada.getNome();
        this.posicao = parada.getPosicao();
    }

    public String getNome() {
        return nome;
    }

    public Posicao getPosicao() {
        return posicao;
    }

}
