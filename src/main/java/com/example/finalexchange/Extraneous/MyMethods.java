package com.example.finalexchange.Extraneous;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
}
