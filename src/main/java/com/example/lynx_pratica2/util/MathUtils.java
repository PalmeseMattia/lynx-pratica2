package com.example.lynx_pratica2.util;

import java.util.Random;

public class MathUtils {
    public static Integer randomNumber(){
        Random rand = new Random(); //instance of random class
        Integer max = 15;
        Integer min = 5;

        Integer randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
