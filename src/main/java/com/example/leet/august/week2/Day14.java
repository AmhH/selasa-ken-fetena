package com.example.leet.august.week2;

/**
 * Longest Palindrome
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that
 * can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Day14 {

    public static int longestPalindrome(String s) {
        int[] map = new int[58];
        for(char c : s.toCharArray()){
            map[c - 'A']++;
        }
        int oddCount = 0;
        for(int i : map){
            if(i % 2 != 0)
                oddCount++;

        }
        int odd = oddCount > 0 ? 1 : 0;
        return s.length() - oddCount + odd;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("abccccddzz"));
        System.out.println(longestPalindrome("abbdccccddzz"));
        System.out.println(longestPalindrome("bb"));
    }
}
