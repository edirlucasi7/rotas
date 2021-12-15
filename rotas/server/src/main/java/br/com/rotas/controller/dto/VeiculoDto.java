package br.com.rotas.controller.dto;

import br.com.rotas.modelo.Veiculo;

public class VeiculoDto {

    private Long id;
    private String nome;

    public VeiculoDto(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.nome = veiculo.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
