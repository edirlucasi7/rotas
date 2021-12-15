package br.com.rotas.controller.util;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaLimpa {

    private @NotEmpty @Size(min = 6) String senha;

    public SenhaLimpa(@NotEmpty @Size(min = 6) String senha) {
        this.senha = senha;
    }

    public String hash() {
        return new BCryptPasswordEncoder().encode(senha);
    }
}
