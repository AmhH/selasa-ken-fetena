package com.example.leet.june.week1;

import java.util.Arrays;
import java.util.Random;

/**
 * Random Pick with Weight
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which
 * randomly picks an index in proportion to its weight.
 *
 * Note:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 *
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the
 * array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class Day5 {
    static class Solution {
        private int[] cumulative;
        private int sum;

        public Solution(int[] w) {
            sum = 0;
            cumulative = new int[w.length];
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                cumulative[i] = sum;
            }

        }

        public int pickIndex() {
            int idx = (int) (Math.random() * sum);
            return binarySearch(idx + 1);
        }

        private int binarySearch(int i) {
            int left = 0;
            int right = cumulative.length - 1;
            while(left < right){
                int mid = left + (right-left)/2;
                if(cumulative[mid] < i){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            return left;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
     */
    public static void main(String[] args) {
        Solution soln = new Solution(new int[]{1});
        System.out.println(soln.pickIndex());
        System.out.println("*******************");

        Solution soln1 = new Solution(new int[]{1, 3});
        System.out.println(soln1.pickIndex());
        System.out.println(soln1.pickIndex());
        System.out.println(soln1.pickIndex());
        System.out.println(soln1.pickIndex());
        System.out.println(soln1.pickIndex());
        System.out.println("&&&&&&&&&&&&&&&&&&&&&");

    }

    static class Solution1 {
        int[] w;
        Random r;
        public Solution1(int[] w) {
            this.w = w;
            r = new Random();
            for (int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }
        }

        public int pickIndex() {
            int lastSum = w[w.length - 1];
            int target = r.nextInt(lastSum) + 1;
            int p = Arrays.binarySearch(w, target);
            return p >= 0 ? p : -p - 1;
        }

        public static void main(String[] args) {
            Solution1 soln12 = new Solution1(new int[]{1});
            System.out.println(soln12.pickIndex());
            System.out.println("*******************");

            Solution1 soln13 = new Solution1(new int[]{1, 3});
            System.out.println(soln13.pickIndex());
            System.out.println(soln13.pickIndex());
            System.out.println(soln13.pickIndex());
            System.out.println(soln13.pickIndex());
            System.out.println(soln13.pickIndex());
            System.out.println("&&&&&&&&&&&&&&&&&&&&&");

        }
    }
}
