package co.edu.unbosque.ElectroShop.utils;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


public class CardPass {
    private static final OkHttpClient client = new OkHttpClient();
    private static final String baseUrl = "https://data.handyapi.com/bin/\"";
    private static final Gson gson = new Gson();

    /**
     * Checks if the given card number is valid.
     *
     * @param card_number the card number to be validated
     * @return true if the card number is valid, false otherwise
     */
    public static boolean isValidCard(String card_number) {
        HttpUrl url = HttpUrl.parse(baseUrl).newBuilder()
                .addPathSegment(card_number)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return parseResponse(response.body().string());
            } else {
                System.err.println("Respuesta no exitosa: " + response.code() + " " + response.message());
                return false;
            }
        } catch (Exception e) {
            System.err.println("Excepción durante la validación de la tarjeta: " + e.getMessage());
            return false;
        }
    }

    /**
     * Parse the response of the CardPass API, returning true if the card is valid,
     * false otherwise.
     *
     * @param jsonResponse the response of the CardPass API
     * @return true if the card is valid, false otherwise
     */
    private static boolean parseResponse(String jsonResponse) {
        try {

            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
            String status = jsonObject.get("Status").getAsString();
            return "SUCCESS".equals(status);
        } catch (Exception e) {
            System.err.println("Excepción durante la validación de la tarjeta: " + e.getMessage());
            return false;
        }
    }



}
