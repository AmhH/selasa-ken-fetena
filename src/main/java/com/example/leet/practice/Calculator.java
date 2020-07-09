package com.example.leet.practice;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Please insert ur inputs");
        Scanner scanner = new Scanner(System.in);
        String postFix = null;
        if (scanner.hasNext()){
            postFix = scanner.nextLine();
        }
        //if space, comma separated/delimited
        int result = postFixWithSpaceCalculator(postFix);// 12 | 3 | *
        //if no separation check how to identify multiple digits
        int result1 = postfixNoSeparation(postFix);//13+//1323+
        System.out.println("Result" + result);
        System.out.println("Result" + result1);

    }

    public static int postfixNoSeparation(String postFix) {
        //single digit
        if(postFix != null && postFix.length() == 3){
            int i1 = Integer.parseInt(postFix.substring(0, 1));
            int i2 = Integer.parseInt(postFix.substring(1, 2));
            char sign = postFix.charAt(2);
            if('*'== sign)
                return i1 * i2;
            if('/'== sign)
                return i1 / i2;
            if('+'== sign)
                return i1 + i2;
            if('-'== sign)
                return i1 - i2;
        }
        System.err.println("Please input all values and try again");

        return 0;
    }

    public static int postFixWithSpaceCalculator(String postFix) {
        if(postFix != null){
            String[] inputs = postFix.split(" ");//","/ ", "
            if(inputs.length == 3){
                int i1 = Integer.parseInt(inputs[0]);
                int i2 = Integer.parseInt(inputs[1]);
                String sign = inputs[2];

                if("*".equals(sign))
                    return i1 * i2;
                if("/".equals(sign))
                    return i1 / i2;
                if("+".equals(sign))
                    return i1 + i2;
                if("-".equals(sign))
                    return i1 - i2;
            }
            System.err.println("Please input all values and try again");
        }
        System.err.println("No values has been inserted please try again");
        return 0;
    }
}
