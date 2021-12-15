package br.com.rotas.controller.dto;

import br.com.rotas.modelo.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public class UsuarioDto {

    private String email;
    private String senha;

    public UsuarioDto(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public static Page<UsuarioDto> converte(Page<Usuario> usuarios) {
        return usuarios.map(UsuarioDto::new);
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
