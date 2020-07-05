package com.example.leet.july.week1;

/**
 * Hamming Distance
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
public class Day5 {

    public static int hammingDistance(int x, int y) {
        int result = 0;
        while(x > 0 || y > 0){
            result += x%2 ^ y%2;
            x = x >> 1;
            y = y >> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    /**
     * Better memory
     */
    class Solution {
        public int hammingDistance(int x, int y) {
            int combined = x ^ y;

            int count = 0;
            while(combined > 0) {
                count += combined & 1;
                combined >>= 1;
            }

            return count;
        }
    }
}
