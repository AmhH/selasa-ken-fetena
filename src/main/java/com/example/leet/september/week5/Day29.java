package com.example.leet.september.week5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class Day29 {
    private static Map<String, Boolean> map = new HashMap();
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        if(map.containsKey(s))
            return map.get(s);
        for(int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            if(wordDict.contains(left) && wordBreak(s.substring(i), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));//true
        System.out.println(wordBreak1("applepenapple", Arrays.asList("apple", "pen")));//true
        System.out.println(wordBreak0("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));//false
    }


    public static boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (String word : wordDict) {
                int j = i - word.length();
                if (j >= 0 && dp[j] && isMatch(s, j, word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private static boolean isMatch(String s, int start, String word) {
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) != s.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean wordBreak0(String s, List<String> wordDict) {
        return helper(s, wordDict, new Boolean[s.length()], 0);
    }

    private static boolean helper(String s, List<String> wordDict, Boolean[] dp, int idx) {
        if (idx >= s.length()) {
            return true;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        for (String w : wordDict) {
            if (s.startsWith(w, idx) && helper(s, wordDict, dp, idx + w.length())) {
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }
}
