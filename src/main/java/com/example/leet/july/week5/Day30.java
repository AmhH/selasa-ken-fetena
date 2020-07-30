package com.example.leet.july.week5;

import java.util.*;

/**
 * Word Break II
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to
 * construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * Example 2:
 *
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 */
public class Day30 {

    static Map<Integer, List<String>> map;
    public static List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return wordBreakHelper(s, s.length(), wordDict);
    }

    private static List<String> wordBreakHelper(String input, int end, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        // We have traversed the input and are done with breaking up the word
        if(end == 0) return new ArrayList<>(Arrays.asList(""));

        // Using dynamic programming for optimisation
        // where the same words will have to broken down again
        if (map.containsKey(end)) {
            return map.get(end);
        }

        // Keeping the end at the end of the input
        // start counter moves along the input letters
        for (int start = 0; start < end; start++) {
            String sub = input.substring(start, end);
            if(wordDict.contains(sub)){
                // Once the last word in the input is found in the dictionary,
                // we repeat the wordbreak
                List<String> tmpList = wordBreakHelper(input, start, wordDict);
                // and append the 'sub' at the end of every phrase in tmpList
                for (String tmpStr : tmpList){
                    res.add(tmpStr.length() == 0 ? sub : tmpStr + " " + sub);
                }
            }
        }
        map.put(end, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
