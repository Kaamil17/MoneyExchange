package com.example.finalexchange.MyApi;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
public class RateApi {


    //  This functions covers the first two major tasks of the projects,which are getting the rate of currency and
    //  converting currencies.
    public HashMap<String, String> exchanger(String baseCurrency, double sourceAmount , String targetCurrency) throws JSONException {
         JSONObject json = null;
        try {
            //  I had some problems with HTTP connection here. So I used a library to get a one liner solution for getting the data from Api in Java.
            json = new JSONObject(org.apache.commons.io.IOUtils.toString(new URL("https://exchange-rates.abstractapi.com/v1/live/?api_key=c0b96d1c04464cef91c2304909193f55&base=" + baseCurrency + "&target=" + targetCurrency), StandardCharsets.UTF_8));

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }


        String rawRate = String.valueOf(json.get("exchange_rates"));
        String[] myArray = rawRate.split(":");

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = myArray[i].replaceAll("[^\\d.,]+", "");
        }

        // we get the rate here
        HashMap<String, String> dataToReturn = new HashMap<>();
        dataToReturn.put("rate", myArray[1]);

        double exchangedAMount = Double.parseDouble(myArray[1] ) * sourceAmount;
        dataToReturn.put("exchangedAmount", String.valueOf(exchangedAMount));

        LocalDateTime instance = LocalDateTime.now();
        dataToReturn.put("dateTime" , String.valueOf(instance));



        return dataToReturn;
    }

}
