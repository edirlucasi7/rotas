//package br.com.rotas.service;

import br.com.rotas.controller.form.ParadaForm;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.List;
//
//@Service
//@Primary
//public class ApiGoogle implements Trajeto{
//
//    @Override
//    public List<ParadaForm> organiza(List<ParadaForm> paradas) throws IOException {
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url("https://maps.googleapis.com/maps/api/directions/json?origin=Adelaide%2C%20SA&destination=Adelaide%2C%20SA&waypoints=optimize%3Atrue%7CBarossa%20Valley%2C%20SA%7CClare%2C%20SA%7CConnawarra%2C%20SA%7CMcLaren%20Vale%2C%20SA&key=YOUR_API_KEY")
//                .method("GET", null)
//                .build();
//        Response response = client.newCall(request).execute();
//    }
//
//}
