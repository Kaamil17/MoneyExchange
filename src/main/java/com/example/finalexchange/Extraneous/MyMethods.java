package com.example.finalexchange.Extraneous;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class MyMethods {

    public String idGenerator() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }
}
