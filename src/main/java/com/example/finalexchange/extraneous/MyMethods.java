package com.example.finalexchange.extraneous;


import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

public class MyMethods {

    // i tried this method for generating a random string for a transaction id other than a single integer
    // which is given by the mysql and hibernate automatically, but i get "BLUB" in my mysql database table instead of
    // the generated string.
    public String idGenerator() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);

        System.out.println();
        return new String(array, StandardCharsets.UTF_8);
    }

    public String apiParser(JSONObject jsonObject) throws JSONException {
        String rawRate = String.valueOf(jsonObject.get("exchange_rates"));
        String[] myArray = rawRate.split(":");

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = myArray[i].replaceAll("[^\\d.,]+", "");
        }
        return myArray[1];
    }

    public HashMap<String, String> writeData(String rate, Double sourceAmount) {
        HashMap<String, String> dataToReturn = new HashMap<>();
        dataToReturn.put("rate", rate);

        double exchangedAMount = Double.parseDouble(rate ) * sourceAmount;
        dataToReturn.put("exchangedAmount", String.valueOf(exchangedAMount));

        LocalDateTime instance = LocalDateTime.now();
        dataToReturn.put("dateTime" , String.valueOf(instance));

        return dataToReturn;
    }




}
