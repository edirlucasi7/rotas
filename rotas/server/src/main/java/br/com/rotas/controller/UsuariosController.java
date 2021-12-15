package br.com.rotas.controller;

import br.com.rotas.controller.dto.UsuarioDto;
import br.com.rotas.controller.form.UsuarioForm;
import br.com.rotas.controller.validator.ProibeEmailDuplicadoValidator;
import br.com.rotas.modelo.Usuario;
import br.com.rotas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private ProibeEmailDuplicadoValidator proibeEmailDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEmailDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDto> cadastra(@RequestBody @Valid UsuarioForm form) {
        Usuario usuario = form.toModel();
        manager.persist(usuario);
        return ResponseEntity.ok().body(new UsuarioDto(usuario));
    }

}
