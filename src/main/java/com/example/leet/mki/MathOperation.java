package com.example.leet.mki;

public class MathOperation {
    static int number2 = getValue();
    static int number1 = 10;
    static int getValue(){
        return number1;
    }

    static int doSum(){
        return number1 + number2;
    }

    static int doMinus(){
        return number1 - number2;
    }

    public static void main(String[] args) {
        System.out.println("Number1 + Number2 = " + doSum());//10
        System.out.println("Number1 - Number2 = " + doMinus());//10
    }
}
