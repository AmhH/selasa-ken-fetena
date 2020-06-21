package com.example.leet.june.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sequence
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class Day20 {

    public static String getPermutation (int n, int k) {

        int[] factorial = new int[n];
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add (i + 1);
            factorial[i] = i == 0 ? 1 : i * factorial[i - 1];
        }

        StringBuilder ans = new StringBuilder ();
        while (n-- != 0) {
            ans.append (nums.remove ((k - 1) / factorial[n]));
            k = (k - 1) % factorial[n] + 1;
        }

        return ans.toString ();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
    }

    class Solution {
        // 18 mins. 2020/06/19
        public String getPermutation(int n, int k) {
            int parts[] = new int[n];
            k--;
            for (int i=n-1; i>=1; i--) {
                int f = fact(i);
                parts[n-1-i] = k / f;
                k = k % f;
            }
            List<Integer> nums = new ArrayList<>();
            for (int i=1; i<=n; i++)
                nums.add(i);
            String res = "";
            for (int i=0; i<n; i++) {
                res += nums.get(parts[i]) + "";
                nums.remove(parts[i]);
            }
            return res;
        }
        private int fact(int n){
            int res = 1;
            for (int i=1; i<=n; i++)
                res *= i;
            return res;
        }

    }
}
