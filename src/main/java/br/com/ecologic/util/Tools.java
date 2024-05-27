package br.com.ecologic.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Calendar;
import java.util.Date;

public class Tools {

    public static void main(String[] args) {
        latitudeLongitude("11015240");
    }

    public static Date retornaDataPosteriorDiasCorridos(Date date, Integer qtde_dias) {

        Date dt_retorno = null;
        try {
            Calendar cal = Calendar.getInstance();
            Date data = new Date(date.getTime());
            cal.setTime(data);
            cal.add(Calendar.DATE, + qtde_dias);
            dt_retorno = new Date(cal.getTime().getTime());
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return dt_retorno;
    }

    public static String[] latitudeLongitude(String cep) {
        String apiKey = "5f0c8512b34d57b37e5e8cd73826aafd"; // Substitua pela sua chave de API do CEP Aberto

        try {
            // Construir a URL da requisição para a API do CEP Aberto
            String cepAbertoUrl = "https://www.cepaberto.com/api/v3/cep?cep=" + cep;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(cepAbertoUrl))
                    .header("Authorization", "Token token=" + apiKey)
                    .header("User-Agent", "Java Geocoding Client")
                    .build();

            // Enviar a requisição e obter a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            Pontos pontos = objectMapper.readValue(response.body(), Pontos.class);

            if (pontos != null) {
                String latitude = pontos.getLatitude();
                String longitude = pontos.getLongitude();

                String[] retorno = new String[2];
                retorno[0] = latitude;
                retorno[1] = longitude;
                return retorno;
            } else {
                System.out.println("Nenhum resultado encontrado para o CEP fornecido.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
