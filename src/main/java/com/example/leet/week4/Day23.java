package com.example.leet.week4;

/**
 *  Bitwise AND of Numbers Range
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this
 * range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */
public class Day23 {
    public static int rangeBitwiseAnd(int m, int n) {
        while(n>m)
            n = n & n-1;
        return m & n;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        Integer integer = new Integer(0);
        System.out.println(integer.equals(0));

    }
}
