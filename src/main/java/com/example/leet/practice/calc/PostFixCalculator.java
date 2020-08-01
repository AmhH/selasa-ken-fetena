package com.example.leet.practice.calc;

import java.util.Scanner;

public class PostFixCalculator {
    static int firstNum;
    static int secondNum;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String amount = scanner.nextLine();
            String operator = amount.substring(amount.length()-1);

            for (int i=0; i<amount.length(); i++) {
                char c2 =amount.charAt(i);
                if (c2 == ' ') {
                    secondNum = Integer.parseInt(amount.substring(i + 1, amount.length() - 1));
                    firstNum = Integer.parseInt(amount.substring(0, i));
                }
            }

            try {
                System.out.println(result1(firstNum, secondNum, operator));
            } catch (Exception e) {
                System.out.println("Enter a space between the numbers and no space between the second number and operator");
                System.out.println("example 14 15* : 14 the first number, 15 the second number and * operator");
            }
        }

    }

    public static int result1(int a, int b, String operator) {
        int res;
        switch (operator) {
            case ("+"):
                return (res = a + b);
            case ("-"):
                return (res = a - b);
            case ("*"):
                return (res = a * b);
            case ("/"):
                return (res = a / b);
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    }
}

