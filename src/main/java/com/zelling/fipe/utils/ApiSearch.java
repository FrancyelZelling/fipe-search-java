package com.zelling.fipe.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiSearch {
    public void apiSearch(String adress) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(adress))
                .build();

        HttpResponse<String> response = null;

        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            System.out.println("Não foi possível completar a requisição");
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Não foi possível completar a requisição");
            throw new RuntimeException(e);
        }
    }
}
