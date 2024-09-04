package co.edu.unbosque.ElectroShop.utils;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CardPass {
    public static String url = "https://data.handyapi.com/bin/";

    /**
     * Verifies if the given credit card number is valid according to the Luhn Algorithm.
     * @param card_number the credit card number to be verified
     * @return <code>true</code> if the card number is valid, <code>false</code> otherwise
     */
    public static boolean isValidCard(String card_number) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url + card_number)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonResponse);
                String status = (String) jsonObject.get("Status");
                return "SUCCESS".equals(status);
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
