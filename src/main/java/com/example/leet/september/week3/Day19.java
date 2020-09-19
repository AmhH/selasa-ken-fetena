package com.example.leet.september.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Sequential Digits
 * An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 *
 *
 *
 * Example 1:
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 * Example 2:
 *
 * Input: low = 1000, high = 13000
 * Output: [1234,2345,3456,4567,5678,6789,12345]
 *
 *
 * Constraints:
 *
 * 10 <= low <= high <= 10^9
 *    Hide Hint #1
 * Generate all numbers with sequential digits and check if they are in the given range.
 *    Hide Hint #2
 * Fix the starting digit then do a recursion that tries to append all valid digits.
 */
public class Day19 {
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        if(low <= 0 && high >= 0) ans.add(0);
        for(int i = 1; i < 10; i++) q.add(i);
        while(q.size() > 0){
            int curr = q.remove();
            if(curr >= low && curr <= high) ans.add(curr);
            int onesDigit = curr % 10;
            if(onesDigit < 9 && curr * 10 + onesDigit + 1 <= high) q.add(curr * 10 + onesDigit + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
        System.out.println(sequentialDigits(1000, 13000));
        System.out.println(sequentialDigits1(1000, 13000));
    }

    public static List<Integer> sequentialDigits1(int low, int high) {
        int[] allNums = {12,23,34,45,56,67,78,89,
                123,234,345,456,567,678,789,
                1234,2345,3456,4567,5678,6789,
                12345,23456,34567,45678,56789,
                123456,234567,345678,456789,
                1234567,2345678,3456789,
                12345678,23456789,
                123456789};
        List<Integer> res = new ArrayList<>();
        int n = allNums.length;
        for (int i = 0; i < n; i++) {
            if (allNums[i] < low) continue;
            if (allNums[i] > high) break;
            res.add(allNums[i]);
        }
        return res;
    }
}
