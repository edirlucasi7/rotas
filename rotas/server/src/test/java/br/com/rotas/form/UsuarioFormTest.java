package br.com.rotas.form;

import br.com.rotas.controller.form.UsuarioForm;
import br.com.rotas.controller.util.SenhaLimpa;
import br.com.rotas.modelo.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsuarioFormTest {

    private UsuarioForm usuarioForm = new UsuarioForm("icety@email.com", "123456");

    @Test
    @DisplayName("cadastra um novo usuario")
    void teste1() throws Exception {

        Usuario usuario = usuarioForm.toModel();

        Assertions.assertNotNull(usuario);
    }

}
