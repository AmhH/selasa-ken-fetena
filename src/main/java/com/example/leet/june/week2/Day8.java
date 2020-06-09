package com.example.leet.june.week2;

/**
 * Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 */
public class Day8 {

    public static boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }

        int div = n;
        while(div % 2 == 0){
            div /= 2;
            if(div == 1)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(218));

        System.out.println(isPowerOfTwo2(2));
        System.out.println(isPowerOfTwo2(16));
        System.out.println(isPowerOfTwo2(218));
    }

    public static boolean isPowerOfTwo2(int n) {
        if(n<=0)
            return false;
        return (n&(-n)) == n;

    }
}
