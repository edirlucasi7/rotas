package br.com.rotas.validator;

import br.com.rotas.controller.form.UsuarioForm;
import br.com.rotas.controller.validator.ProibeEmailDuplicadoValidator;
import br.com.rotas.modelo.Usuario;
import br.com.rotas.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Optional;

public class ProibeEmailDuplicadoValidatorTest {

    private UsuarioRepository repository = Mockito.mock(UsuarioRepository.class);
    private UsuarioForm request = new UsuarioForm("icety@gmail","123456");

    @Test
    @DisplayName("nao deveria permitir request de novo usuario com email duplicado")
    void teste1() throws Exception {
        Usuario usuario = request.toModel();
        Mockito.when(repository.findByEmail(request.getEmail())).thenReturn(Optional.ofNullable(usuario));

        Errors errors = new BeanPropertyBindingResult(request, "target");
        ProibeEmailDuplicadoValidator validator = new ProibeEmailDuplicadoValidator(repository);

        validator.validate(request, errors);

        Assertions.assertTrue(errors.hasErrors());
        Assertions.assertEquals("Ja existe um usuario cadastrado com o mesmo email!", errors.getFieldErrors().get(0).getDefaultMessage());

    }

    @Test
    @DisplayName("deveria permitir request de novo usuario com email nao duplicado")
    void teste2() throws Exception {

        Errors errors = new BeanPropertyBindingResult(request, "target");
        ProibeEmailDuplicadoValidator validator = new ProibeEmailDuplicadoValidator(repository);

        validator.validate(request, errors);

        Assertions.assertFalse(errors.hasErrors());
    }

    @Test
    @DisplayName("deveria parar caso já tenha erro")
    void teste3() throws Exception {

        Errors errors = new BeanPropertyBindingResult(request, "target");
        errors.reject("email");

        ProibeEmailDuplicadoValidator validator = new ProibeEmailDuplicadoValidator(repository);
        validator.validate(request, errors);

        Assertions.assertTrue(errors.hasErrors());
        Assertions.assertEquals("email", errors.getGlobalErrors().get(0).getCode());

    }

}
