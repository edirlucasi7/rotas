package br.com.rotas.controller;

import br.com.rotas.controller.dto.VeiculoDto;
import br.com.rotas.controller.form.VeiculoForm;
import br.com.rotas.modelo.Veiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<VeiculoDto> cadastra(@RequestBody @Valid VeiculoForm form, UriComponentsBuilder uriComponentsBuilder) {
        Veiculo veiculo = form.toModel();

        manager.persist(veiculo);

        URI uri = uriComponentsBuilder.path("/veiculos/{id}").buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).body(new VeiculoDto(veiculo));
    }

}
