package com.example.finalexchange.Api;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

@RestController
public class RateApi {


    // Here, we find the exchange rate of two currencies.
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


//    public HashMap<String, String> conversionTotalFinder(double sourceAmount, String sourceCurrency, String targetCurrency) throws JSONException {
//
//        HashMap<String,String > toReturn = new HashMap<String, String>();
//        double currencyRate = rateFinder(sourceCurrency, targetCurrency);
//        toReturn.put("Amount" ,String.valueOf(sourceAmount * currencyRate));
//        // getting the date and time
//        LocalDateTime instance = LocalDateTime.now();
//        toReturn.put("Date and Time" , String.valueOf(instance));
//
//        return toReturn;
//    }




}
