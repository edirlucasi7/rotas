package br.com.rotas.form;

import br.com.rotas.controller.form.ParadaForm;
import br.com.rotas.controller.form.PosicaoForm;
import br.com.rotas.controller.form.RotaForm;
import br.com.rotas.modelo.Rota;
import br.com.rotas.modelo.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

public class ParadaFormTest {

    EntityManager manager = Mockito.mock(EntityManager.class);

    private PosicaoForm requestPosicao = new PosicaoForm("-12313121", "21212121");
    private List<ParadaForm> requestParada = Arrays.asList(new ParadaForm("Joao Pessoa", requestPosicao));
    private RotaForm requestForm = new RotaForm("Fortaleza/Maceio", "","", 1l, requestParada);

    private ParadaForm paradaForm = new ParadaForm("teste", requestPosicao);

    @Test
    @DisplayName("cria uma parada que esta associada com uma rota")
    void teste1() throws Exception {

        EntityManager manager = Mockito.mock(EntityManager.class);

        Mockito.when(manager.find(Veiculo.class, 1l))
                .thenReturn(new Veiculo(""));

        Rota rota = requestForm.toModel(manager, "akfnwnfjiandj");

        Assertions.assertNotNull(paradaForm.toModel(rota));
    }

}
