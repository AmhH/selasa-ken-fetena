package com.example.leet.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {

    public static void main(String[] args) {

        BigDecimal bd1 = new BigDecimal("10.2");
        System.out.println(bd1);
        BigDecimal bd2 = bd1.setScale(3, RoundingMode.CEILING);
        System.out.println(bd2);

    }
}
