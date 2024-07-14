package com.nawab.snakeLadder.model;

import java.util.Random;

public class Dice {
    public Integer getRandomNumber(){
        return new Random().nextInt(6) + 1;
    }
}
