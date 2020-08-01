package com.example.leet.july.week5;

/**
 * Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class Day31 {

    public static int climbStairs(int n) {
        return climbStairsHelper(n, new int[n+1]);
    }

    private static int climbStairsHelper(int n, int[] memo) {
        if(n==0 || n==1){
            return 1;
        }
        if(memo[n] > 0)
            return memo[n];
        int res = climbStairsHelper(n-1, memo) + climbStairsHelper(n-2, memo);
        memo[n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(8));
        System.out.println(climbStairs1(8));
    }

    public static int climbStairs1(int n) {
        if(n == 1 || n == 2)
            return n;
        int result = 1, prev1 = 1, prev2 = 2;
        for(int i = 3; i <= n; i++) {
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }
        return result;
    }
}
