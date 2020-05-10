package com.example.leet.may.week2;

/**
 * Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * Example 2:
 * <p>
 * Input: 14
 * Output: false
 */
public class Day9 {

    public static boolean isPerfectSquare(int num) {

        if (num == 0 || num == 1)
            return true;

        long left = 1, right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) return true; // check if mid is perfect square
            if (mid * mid < num) { // mid is small -> go right to increase mid
                left = mid + 1;
            } else {
                right = mid - 1; // mid is large -> to left to decrease mid
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
        long start = System.currentTimeMillis();
        System.out.println(isPerfectSquare(2147483647));
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + "Seconds");

    }
}
