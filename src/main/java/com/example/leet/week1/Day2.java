package com.example.leet.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number
 * by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or
 * it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Day2 {

    public static boolean isHappy(int n) {
        int sum = n;
        while(true){
            if(sum == 1 || sum == 7){
                return true;
            }
            if (sum < 10){
                return false;
            }
            sum = sumDigitsSquare(sum);
        }
    }

    private static int sumDigitsSquare(int sum){
        int squareSum = 0;
        while(sum != 0){
            int mod = sum % 10;
            squareSum += (mod * mod);
            sum = sum / 10;
        }

        return squareSum;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(19));
        System.out.println(isHappy(1));
        System.out.println(isHappy(7));
        System.out.println(isHappy(10));
        System.out.println(isHappy(18));
        System.out.println(isHappy(20));

        System.out.println("********************************");

        System.out.println(isHappy2(19));
        System.out.println(isHappy2(1));
        System.out.println(isHappy2(7));
        System.out.println(isHappy2(10));
        System.out.println(isHappy2(18));
        System.out.println(isHappy2(20));
        System.out.println(""+Runtime.getRuntime().availableProcessors());
    }

    public static boolean isHappy2(int n) {
        n = Math.abs(n);
        Set<Integer> exist = new HashSet<>();
        while (n != 1) {
            if (!exist.add(n)) {
                return false;
            }

            int tmp = 0;
            while (n > 0) {
                tmp += Math.pow((n % 10), 2);
                n /= 10;
            }
            n = tmp;
        }
        return true;
    }
}