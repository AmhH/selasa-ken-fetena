package com.example.leet.june.week1;

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
    class Solution {
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

    }
}
