package com.example.leet.august.week1;

/**
 * Power of Four
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 */
public class Day4 {
    public static boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        double logValue = Math.log(num)/Math.log(4);
        return (logValue % 1) == 0 ;
    }

    public static boolean isPowerOfFour1(int num) {
        return num > 0 &&
                (num & (num - 1)) == 0 &&
                (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(32));
        System.out.println(isPowerOfFour(64));
        System.out.println(isPowerOfFour1(64));
        System.out.println(0x55555555);
    }
}
