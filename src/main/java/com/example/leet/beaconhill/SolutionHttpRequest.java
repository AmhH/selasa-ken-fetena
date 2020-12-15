package com.example.leet.beaconhill;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.*;

import java.util.Optional;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

// Main class should be named 'Solution'
public class SolutionHttpRequest {
  public static void main(String[] args) throws IOException, InterruptedException{
    HttpClient client = HttpClient.newHttpClient();

    HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8081/products"))
        .GET()
        .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    ObjectMapper mapper = new ObjectMapper();
    List<Product> products = mapper.readValue(response.body(), new TypeReference<List<Product>>() {});
    products.forEach(product -> System.out.println("Product " + product.getName() + " has price " + product.getPrice() + " and "
        + Optional.ofNullable(product.getManufacturer()).map(m -> "manufacturer " + m).orElse("no manufacturer")));
  }
}
