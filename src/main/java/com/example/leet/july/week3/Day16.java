package com.example.leet.july.week3;

/**
 * Pow(x, n)
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class Day16 {
    public static double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        System.out.println(myPow1(2.00000, 10));
        System.out.println(myPow1(2.10000, 3));
        System.out.println(myPow1(2.00000, -2));

        System.out.println(myPow(6.45600, -98));
        System.out.println(myPow(87.08700, 24));
    }

    public static double myPow1(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (x == 1.0) return 1;

        if (x > 0 && n == Integer.MIN_VALUE) return 0;
        if (x < 0 && n == Integer.MIN_VALUE) return 1;
        if (x > 0 && n == Integer.MAX_VALUE) return 0;
        if (x < 0 && n == Integer.MAX_VALUE) return -1;

        double res = 1;
        boolean powIsNegative = (n < 0);

        res = fastpow(x, n);
        if (powIsNegative) return 1 / res;

        return res;
    }

    private static double fastpow(double x, int n) {
        if (n == 0) return 1;

        double half = fastpow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

    }

}
