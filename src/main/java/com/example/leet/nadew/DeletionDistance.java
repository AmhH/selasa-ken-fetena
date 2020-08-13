package com.example.leet.nadew;

/**
 * The deletion distance of two strings is the minimum number of characters you need to delete in the two strings in
 * order to get the same string. For instance, the deletion distance between "heat" and "hit" is 3:
 * By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
 * We cannot get the same string from both strings by deleting 2 letters or fewer.
 * Given the strings str1 and str2, write an efficient function deletionDistance that returns the deletion distance
 * between them. Explain how your function works, and analyze its time and space complexities.
 *
 * input:  str1 = "dog", str2 = "frog"
 * output: 3
 *
 * input:  str1 = "some", str2 = "some"
 * output: 0
 *
 * input:  str1 = "some", str2 = "thing"
 * output: 9
 *
 * input:  str1 = "", str2 = ""
 * output: 0
 * https://leetcode.com/problems/delete-operation-for-two-strings/solution/
 */
public class DeletionDistance {

    public static int minDistance(String s1, String s2) {
        return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length());
    }

    /**
     * LCS Longest Common Subsequence
     * @param s1 String one
     * @param s2 String two
     * @param m index for string one
     * @param n index for string two
     * @return longest common subsequence length
     */
    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + lcs(s1, s2, m - 1, n - 1);
        else
            return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }

    public static int minDistanceMemo(String s1, String s2) {
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        return s1.length() + s2.length() - 2 * lcsMemo(s1, s2, s1.length(), s2.length(), memo);
    }

    public static int lcsMemo(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0)
            return 0;
        if(memo[m][n] > 0)
            return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            memo[m][n] = 1 + lcsMemo(s1, s2, m - 1, n - 1, memo);
        else
            memo[m][n] = Math.max(lcsMemo(s1, s2, m, n - 1, memo), lcsMemo(s1, s2, m - 1, n, memo));
        return memo[m][n];
    }

    public static int minDistanceDP(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return s1.length() + s2.length() - 2 * dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("dog", "frog"));//3
        System.out.println(minDistance("some", "some"));//0
        System.out.println(minDistance("some", "thing"));//9
        System.out.println(minDistanceMemo("some", "thing"));//9
        System.out.println(minDistanceDP("some", "thing"));//9
        System.out.println(minDistance("", ""));//0
    }
}
