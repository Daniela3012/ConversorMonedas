import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConsultaMoneda {
    private String direction = "https://v6.exchangerate-api.com/v6/6ad89a4ba61868b7e90f493f/latest/";
    private String baseCurrency;

    public TypeChange conversion(String baseCurrency) throws IOException, InterruptedException {
        this.baseCurrency = baseCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direction+baseCurrency))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TypeChange.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No encontré esa pelicula");
        }
    }
}
