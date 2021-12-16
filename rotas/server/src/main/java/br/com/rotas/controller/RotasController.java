package br.com.rotas.controller;

import br.com.rotas.controller.dto.RotaDto;
import br.com.rotas.controller.form.RotaForm;
import br.com.rotas.modelo.Rota;
import br.com.rotas.repository.RotaRepository;
import br.com.rotas.service.TrajetoOtimizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;

import java.util.Optional;

@RestController
@RequestMapping("/rotas")
public class RotasController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private RotaRepository repository;
    @Autowired
    private TrajetoOtimizado trajetoOtimizado;

    @PostMapping
    @Transactional
    public ResponseEntity<RotaDto> cadastra(@RequestBody @Valid RotaForm form,
                                            UriComponentsBuilder uriComponentsBuilder) throws IOException {

        String caminhoEncodado = trajetoOtimizado.encodeCaminho(form.getParadas());

        Rota rota = form.toModel(manager, caminhoEncodado);
        manager.persist(rota);

        URI uri = uriComponentsBuilder.path("/rotas/{id}").buildAndExpand(rota.getId()).toUri();
        return ResponseEntity.created(uri).body(new RotaDto(rota));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RotaDto> detalhe(@PathVariable("id") Long idRota) {
        Optional<Rota> optionalRota = repository.findById(idRota);
        if(optionalRota.isPresent()) {
            return ResponseEntity.ok(new RotaDto(optionalRota.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
