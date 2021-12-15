package br.com.rotas.controller.form;

import br.com.rotas.controller.util.SenhaLimpa;
import br.com.rotas.modelo.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UsuarioForm {

    private @NotEmpty @Email String email;
    private @NotEmpty @Size(min = 6) String senha;

    public UsuarioForm(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario toModel() {
        return new Usuario(email, new SenhaLimpa(senha));
    }

    public String getSenha() {
        return this.senha;
    }

    public String getEmail() {
        return this.email;
    }
}
