package com.example.leet.practice.calc;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckWriter2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (scanner.hasNext()) {
            try {
                double amount = scanner.nextDouble();
                convertNumber(amount);
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("try again");
            }
        }
    }

    public static String checkWriterMethod(int number, double amount) {
        String[] onePlaced = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tenthPlaced = {"", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};
        StringBuilder sb = new StringBuilder();
        if (amount < 100) {
            if (number == 0) {
                sb.append("zero ");
            } else if (number >= 20) {
                int oneDig = number % 10;
                int tenthDig = number / 10; //
                String result = tenthPlaced[tenthDig - 1].concat(onePlaced[oneDig]);
                sb.append(result);
            } else {
                String resul = onePlaced[number];
                sb.append(resul);
            }
        } else {
            System.err.println("Enter a number between 0 and 99");
        }
        return sb.toString();
    }

    public static void convertNumber(double amount) {
        if (amount < 100) {
            DecimalFormat format = new DecimalFormat("0.00");
            double amountOne = Double.parseDouble(format.format(amount)) * 100;
            int beforeZero = (int) (amountOne / 100);
            int afterZero = (int) (amountOne % 100);
            System.out.print(checkWriterMethod(beforeZero, amount) + " dollar");
            System.out.print(" and " + checkWriterMethod(afterZero, amount) + " cents");
        } else {
            System.err.println("Enter a number between 0 and 99");
        }

    }
}
