package com.example.leet.week1;

import java.util.HashSet;
import java.util.Set;

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
    }
}

class Solution {
    public boolean isHappy(int n) {
        n = (int) Math.abs(n);
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