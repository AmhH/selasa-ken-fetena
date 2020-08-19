package com.example.leet.august.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Numbers With Same Consecutive Differences
 * Return all non-negative integers of length N such that the absolute difference between every two consecutive
 * digits is K.
 * <p>
 * Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01
 * has one leading zero and is invalid, but 0 is valid.
 * <p>
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: N = 3, K = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * Example 2:
 * <p>
 * Input: N = 2, K = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 9
 * 0 <= K <= 9
 * Solution: https://leetcode.com/problems/numbers-with-same-consecutive-differences/solution/
 */
public class Day18 {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            backtracking(numbers, i, i, 1, N, K);
        }

        int[] result = new int[numbers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = numbers.get(i);
        }
        return result;
    }

    private void backtracking(List<Integer> numbers, int number, int digit, int length, int N, int K) {
        if (length == N) {
            numbers.add(number);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (Math.abs(digit - i) == K) {
                number = number * 10 + i;
                backtracking(numbers, number, i, length + 1, N, K);
                number = (number - i) / 10;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Day18().numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(new Day18().numsSameConsecDiff(2, 1)));
    }

    class Solution {

        public int[] numsSameConsecDiff(int N, int K) {

            if (N == 1)
                return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

            List<Integer> queue = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            for(int level = 1; level < N; ++ level) {
                ArrayList<Integer> nextQueue = new ArrayList<>();
                // iterate through each number within the level
                for (Integer num : queue) {
                    Integer tailDigit = num % 10;

                    ArrayList<Integer> nextDigits = new ArrayList<>();
                    nextDigits.add(tailDigit + K);
                    if (K != 0)
                        nextDigits.add(tailDigit - K);
                    for (Integer nextDigit : nextDigits) {
                        if (0 <= nextDigit && nextDigit < 10) {
                            Integer newNum = num * 10 + nextDigit;
                            nextQueue.add(newNum);
                        }
                    }
                }
                // prepare for the next level
                queue = nextQueue;
            }

            return queue.stream().mapToInt(i->i).toArray();
        }
    }
}
