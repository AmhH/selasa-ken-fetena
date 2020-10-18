package com.example.leet.october.week3;

import java.util.ArrayList;
import java.util.List;

/**
 *  Best Time to Buy and Sell Stock IV
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Notice that you may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you
 * buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price =
 * 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 *
 * Constraints:
 *
 * 0 <= k <= 109
 * 0 <= prices.length <= 104
 * 0 <= prices[i] <= 1000
 */
public class Day18 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // solve special cases
        if (n <= 0 || k <= 0) {
            return 0;
        }

        // find all consecutively increasing subsequence
        List<int[]> transactions = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] >= prices[i - 1]) {
                end = i;
            } else {
                if (end > start) {
                    int[] t = { start, end };
                    transactions.add(t);
                }
                start = i;
            }
        }
        if (end > start) {
            int[] t = { start, end };
            transactions.add(t);
        }

        while (transactions.size() > k) {
            // check delete loss
            int delete_index = 0;
            int min_delete_loss = Integer.MAX_VALUE;
            for (int i = 0; i < transactions.size(); i++) {
                int[] t = transactions.get(i);
                int profit_loss = prices[t[1]] - prices[t[0]];
                if (profit_loss < min_delete_loss) {
                    min_delete_loss = profit_loss;
                    delete_index = i;
                }
            }

            // check merge loss
            int merge_index = 0;
            int min_merge_loss = Integer.MAX_VALUE;
            for (int i = 1; i < transactions.size(); i++) {
                int[] t1 = transactions.get(i - 1);
                int[] t2 = transactions.get(i);
                int profit_loss = prices[t1[1]] - prices[t2[0]];
                if (profit_loss < min_merge_loss) {
                    min_merge_loss = profit_loss;
                    merge_index = i;
                }
            }

            // delete or merge
            if (min_delete_loss <= min_merge_loss) {
                transactions.remove(delete_index);
            } else {
                int[] t1 = transactions.get(merge_index - 1);
                int[] t2 = transactions.get(merge_index);
                t1[1] = t2[1];
                transactions.remove(merge_index);
            }

        }

        int res = 0;
        for (int[] t : transactions) {
            res += prices[t[1]] - prices[t[0]];
        }

        return res;
    }

    public int maxProfit1(int k, int[] prices) {
        if (k <= 0 || prices.length == 0) {
            return 0;
        }

        // we have unlimited transactions within prices
        if (2 * k > prices.length) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }

        int[][] dp = new int[k + 1][prices.length];
        for (int i = 0; i < k + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < prices.length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < prices.length; j++) {
                max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], max + prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }

    // Other links stock question:
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/share-my-dp-solution-by-state-machine-thinking
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54125/Very-understandable-solution-by-reusing-Problem-III-idea

// Idea derived form 2 transaction question - stock buy and sell III:
// We can also explain the above codes in other words.
// On every day, we buy the share with the price as low as we can, and sell the share with price as high as we can.
// For the second transaction, we integrate the profit of first transaction into the cost of the second buy, then the profit of the second sell will be the total profit of two transactions.
// public int maxProfit(int[] prices)  {
//     int min1 = prices[0];
//     int profit1 = 0;

//     int min2 = prices[0];
//     int profit2 = 0;

//     for(int i = 1; i < prices.length; i++) {
//         min1 = Math.min(min1, prices[i]);
//         profit1 = Math.max(profit1, prices[i] - min1);

//         min2 = Math.min(min2, prices[i] - profit1);
//         profit2 = Math.max(profit2, prices[i] - min2);
//     }

//     return profit2;
// }

    class Solution {
        public int maxProfit(int k, int[] prices) {
            // if k >= n/2, then you can make maximum number of transactions
            // required only for LC MLE but is really an edge case optimization
            if(k > prices.length / 2) {
                int profit = 0;
                for(int i = 1; i < prices.length; i++) {
                    if(prices[i] > prices[i-1]) {
                        profit += prices[i] - prices[i-1];
                    }
                }
                return profit;
            }

            int[] buy = new int[k+1];
            int[] sell = new int[k+1];

            for(int i = 0; i < buy.length; i++) {
                buy[i] = Integer.MIN_VALUE;
            }

            for(int price : prices) {
                for(int i = 0; i < k; i++) {
                    sell[i] = Math.max(sell[i], buy[i] + price);
                    buy[i] = Math.max(buy[i], sell[i+1] - price);
                }
            }
            return sell[0];
        }
    }
}
