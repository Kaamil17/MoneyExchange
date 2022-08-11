package com.example.finalexchange.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

@Service("api-service")
public class ApiService {

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
