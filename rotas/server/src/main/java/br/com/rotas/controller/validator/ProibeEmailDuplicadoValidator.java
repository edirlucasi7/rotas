package br.com.rotas.controller.validator;

import br.com.rotas.controller.form.UsuarioForm;
import br.com.rotas.modelo.Usuario;
import br.com.rotas.repository.UsuarioRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoValidator implements Validator {

    private UsuarioRepository repository;

    public ProibeEmailDuplicadoValidator(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UsuarioForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        UsuarioForm request = (UsuarioForm)target;
        Optional<Usuario> usuario = repository.findByEmail(request.getEmail());
        if(usuario.isPresent()) {
           errors.rejectValue("email", null, "Ja existe um usuario cadastrado com o mesmo email!");
        }

    }
}
