package com.example.leet.practice.calc;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CheckWriter {
        static String[] onePlaced = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven",
                "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        static String[] tenthPlaced = {"","twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ",
                "ninety "};

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                double amount = scanner.nextDouble();
                DecimalFormat format = new DecimalFormat("0.00");
                double amountOne = Double.parseDouble(format.format(amount)) * 100;
                int beforeZero = (int) (amountOne / 100);
                int afterZero = (int) (amountOne % 100);
                try {
                    System.out.println(beforeZeroMethod(beforeZero) + afterZeroMethod(afterZero));
                } catch (Exception e) {
                    System.out.println("Enter a number between 0 and 99");
                }
            }
        }
        public static String beforeZeroMethod(int beforeZero) {
            while (beforeZero>=0) {
                if (beforeZero == 0) {
                    return "zero "+ " dollar ";
                }
                else if (beforeZero>=20) {
                    int oneDig = beforeZero % 10;
                    int tenthDig = beforeZero / 10; //
                    String result = tenthPlaced[tenthDig - 1].concat(onePlaced[oneDig]);
                    return result + " dollar ";
                } else
                {
                    String resul =onePlaced[beforeZero];
                    return resul + " dollar ";
                }
            }
            return null;
        }

        public static String afterZeroMethod(int afterZero) {

            while (afterZero>=0) {
                if (afterZero == 0) {
                    return "and zero cents";
                }
                else if (afterZero>=20) {
                    int oneDig = afterZero % 10; //98, 9
                    int tenthDig = afterZero / 10; //
                    String result = tenthPlaced[tenthDig - 1].concat(onePlaced[oneDig]);
                    return "and " + result+" cents";
                } else
                {
                    String resul =onePlaced[afterZero];
                    return "and " + resul+" cents";
                }
            }
            return null;
        }
}

