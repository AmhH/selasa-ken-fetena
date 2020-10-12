package com.example.leet.october.week2;

/**
 * Remove Duplicate Letters
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible results.
 *
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 *    Hide Hint #1
 * Greedily try to add one missing character. How to check if adding some character will not cause problems ? Use
 * bit-masks to check whether you will be able to complete the sub-sequence if you add the character at some index i.
 */
public class Day11 {
    public static String removeDuplicateLetters(String s) {

    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));//abc
        System.out.println(removeDuplicateLetters("cbacdcbc"));//acdb
    }
}
