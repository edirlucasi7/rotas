package br.com.rotas.service;

import br.com.rotas.controller.form.ParadaForm;
import br.com.rotas.modelo.Parada;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class OtimizacaoApiGoogle implements OtimizaRota{

    @Override
    public List<Integer> organizaCaminho(List<Parada> paradas, String origem, String destino) throws IOException {

        String param = "";
        for (Parada parada : paradas) {
            param += "|";
            param += parada.getPosicao().getLatitude()+","+parada.getPosicao().getLongitude();
        }

        RestTemplate client = new RestTemplate();
        ResponseEntity<String> exchange = client.exchange("https://maps.googleapis.com/maps/api/directions/json?key=AIzaSyAPjgxN7NiJzQFZtg8vLJSVTeUR-HHV1tw&language=pt_BR&" +
                        "waypoints=optimize:true"+param+"&origin="+origem+"&destination="+destino+"",
                HttpMethod.GET, null, String.class);

        String jsonString = exchange.getBody();
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("routes");

        List<Integer> listdata = new ArrayList<Integer>();

        for (int i = 0; i < arr.length(); i++) {
            {
                JSONArray waypoint_order = arr.getJSONObject(i).getJSONArray("waypoint_order");
                for(int y = 0; y < waypoint_order.length(); y++) {
                    listdata.add(Integer.valueOf(waypoint_order.getInt(y)));
                }
            }
            return listdata;
        }
        return null;
    }

    @Override
    public String encodaCaminho(List<ParadaForm> paradas, String origem, String destino) {

        String param = "";
        for (ParadaForm parada : paradas) {
            param += "|";
            param += parada.getPosicaoForm().getLatitude()+","+parada.getPosicaoForm().getLongitude();
        }

        RestTemplate client = new RestTemplate();
        ResponseEntity<String> exchange = client.exchange("https://maps.googleapis.com/maps/api/directions/json?key=AIzaSyAPjgxN7NiJzQFZtg8vLJSVTeUR-HHV1tw&language=pt_BR&" +
                        "waypoints=optimize:true"+param+"&origin="+origem+"&destination="+destino+"",
                HttpMethod.GET, null, String.class);

        String jsonString = exchange.getBody();
        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("routes");
        for (int i = 0; i < arr.length(); i++)
        {
            String path = arr.getJSONObject(i).getJSONObject("overview_polyline").getString("points");
            return path;
        }
        return "";
    }

}
