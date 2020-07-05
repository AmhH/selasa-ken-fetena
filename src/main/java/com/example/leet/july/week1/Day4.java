package com.example.leet.july.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * Ugly Number II
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 *    Hide Hint #1
 * The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try
 * to focus your effort on generating only the ugly ones.
 *    Hide Hint #2
 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 *    Hide Hint #3
 * The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted
 * lists: L1, L2, and L3.
 *    Hide Hint #4
 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 */
public class Day4 {

    //
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);

        int twoIndex = 0;
        int threeIndex = 0;
        int fiveIndex = 0;

        while (ugly.size() < n) {
            int by2 = ugly.get(twoIndex) * 2;
            int by3 = ugly.get(threeIndex) * 3;
            int by5 = ugly.get(fiveIndex) * 5;

            int min = Math.min(by2, Math.min(by3, by5));
            ugly.add(min);

            if (min == by2) twoIndex++;
            if (min == by3) threeIndex++;
            if (min == by5) fiveIndex++;
        }

        return ugly.get(ugly.size() - 1);
    }

    //sample 2 ms
    public int nthUglyNumber1(int n) {
        int[] uglyNumber=new int[n+1];
        uglyNumber[0]=1;
        int index2=0, index3=0, index5=0;
        for(int i=1; i<n; i++) {
            uglyNumber[i]=Math.min(uglyNumber[index2]*2, Math.min(uglyNumber[index3]*3, uglyNumber[index5]*5));

            if(uglyNumber[i]==uglyNumber[index2]*2)
                index2++;
            if(uglyNumber[i]==uglyNumber[index3]*3)
                index3++;
            if(uglyNumber[i]==uglyNumber[index5]*5)
                index5++;
        }
        return uglyNumber[n-1];
    }
    public static void main(String[] args) {
        System.out.println(new Day4().nthUglyNumber(10));
        System.out.println(new Day4().nthUglyNumber(10));
    }

    //sample 1 ms
    class Solution {

        public  Ugly ugly = new Ugly();
        public int nthUglyNumber(int n) {

            return ugly.nums[n-1];

        }
    }

    class Ugly {

        int[] nums;

        public Ugly(){
            nums = new int[1690];
            nums[0] = 1;
            int i2 = 0, i3 = 0, i5 = 0;
            for(int i=1;i<1690;i++){

                nums[i] = Math.min(Math.min(nums[i2]*2, nums[i3]*3), nums[i5]*5);

                if(nums[i]==nums[i2]*2) i2++;
                if(nums[i]==nums[i3]*3) i3++;
                if(nums[i]==nums[i5]*5) i5++;
            }
        }

    }
}
