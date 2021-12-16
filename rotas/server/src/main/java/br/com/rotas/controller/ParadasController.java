package br.com.rotas.controller;

import br.com.rotas.controller.dto.ParadaDto;
import br.com.rotas.modelo.Parada;
import br.com.rotas.modelo.Rota;
import br.com.rotas.service.OtimizaRota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/paradas")
public class ParadasController {

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private OtimizaRota otimizacaoRota;

    @GetMapping("/{id}")
    public ResponseEntity<List<ParadaDto>> retornaRotasOrdenadas(@PathVariable("id") Long id) throws IOException {
        Rota rota = manager.find(Rota.class, id);

        List<Integer> ordem = otimizacaoRota.organizaCaminho(rota.getParadas(), rota.getOrigem(), rota.getDestino());
        List<ParadaDto> paradasOrdenadas = new ArrayList<>();

        for (Integer index : ordem) {
            ParadaDto parada = new ParadaDto(rota.getParadas().get(index));
            paradasOrdenadas.add(parada);
        }

        return ResponseEntity.ok(paradasOrdenadas);
    }

}
