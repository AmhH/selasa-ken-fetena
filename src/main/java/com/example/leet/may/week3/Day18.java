package com.example.leet.may.week3;

/**
 * Permutation in String
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words,
 * one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 *    Hide Hint #1
 * Obviously, brute force will result in TLE. Think of something else.
 *    Hide Hint #2
 * How will you check whether one string is a permutation of another string?
 *    Hide Hint #3
 * One way is to sort the string and then compare. But, Is there a better way?
 *    Hide Hint #4
 * If one string is a permutation of another string then they must one common metric. What is that?
 *    Hide Hint #5
 * Both strings must have same character frequencies, if one is permutation of another. Which data structure should be
 * used to store frequencies?
 *    Hide Hint #6
 * What about hash table? An array of size 26?
 */
public class Day18 {

    public static boolean checkInclusion(String s1, String s2) {
        int[] map = new int[26];
        for(char c : s1.toCharArray())
            map[c - 'a']++;
        int j = 0, i = 0;
        int count = s1.length();
        while(j < s2.length()){
            if(map[s2.charAt(j++) - 'a']-- > 0)
                count--;
            if(count == 0) return true;
            if(j - i == s1.length() && map[s2.charAt(i++) - 'a']++ >= 0)
                count++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));

        System.out.println(checkInclusion2("ab", "eidbaoooab"));
    }

    public static boolean checkInclusion2(String s1, String s2) {
        if (s1 == null) return s2 == null;
        if (s1.equals(s2)) return true;
        if (s1.length() > s2.length()) return false;
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        int l = 0;
        int r = 0;
        int len = s1.length();
        int count = len;
        while (r < s2.length()) {
            if (cnt[s2.charAt(r++) - 'a']-- > 0) {
                count--;
            }
            if (count == 0) return true;
            if (r - l == len && cnt[s2.charAt(l++) - 'a']++ >= 0) {
                count++;
            }
        }
        return false;
    }
}
