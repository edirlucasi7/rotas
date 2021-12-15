package br.com.rotas.controller.dto;

import br.com.rotas.modelo.Usuario;

public class UsuarioIdDto {

    private Long id;

    public UsuarioIdDto(Usuario usuario) {
        this.id = usuario.getId();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
