package com.example.finalexchange.myapi;

import com.example.finalexchange.service.ApiService;
import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import com.example.finalexchange.service.apiServiceInterface;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


@RestController
public class RateApi implements apiServiceInterface {


    //  This functions covers the first two major tasks of the projects,which are getting the rate of currency and
    //  converting currencies.

    @SneakyThrows
    public HashMap<String, String> exchanger(String baseCurrency, double sourceAmount, String targetCurrency) {
        JSONObject json = null;
        try {
            //  I had some problems with HTTP connection here. So I used a library to get a one liner solution for getting the data from Api in Java.
            json = new JSONObject(org.apache.commons.io.IOUtils.toString(new URL("https://exchange-rates.abstractapi.com/v1/live/?api_key=c0b96d1c04464cef91c2304909193f55&base=" + baseCurrency + "&target=" + targetCurrency), StandardCharsets.UTF_8));
            // use cloud
        } catch (JSONException | IOException e) {
            System.out.println("Please check if the currency abbreviation is correct");
            System.exit(1);
        }

        ApiService apiService = new ApiService();
        String rate;

        // instead of hardcoding, I implemented two functions and called them here.
        rate = apiService.apiParser(json);
        return apiService.writeData(rate, sourceAmount);
    }
}
