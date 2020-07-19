package com.example.leet.july.week3;

import java.util.Arrays;

/**
 * Reverse Words in a String
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or
 * trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
public class Day15 {

    public static String reverseWords(String s) {
         return Arrays.stream(s.split(" "))
                    .filter(str -> !str.trim().isEmpty())
                    .map(StringBuilder::new)
                    .reduce(new StringBuilder(), (a,b) -> b.append(" ").append(a)).toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
        System.out.println("*******************");
        System.out.println(reverseWords1("the sky is blue"));
        System.out.println(reverseWords1("  hello world!  "));
        System.out.println(reverseWords1("a good   example"));
    }


    public static String reverseWords1(String s) {
        if (s == null) {
            return s;
        }

        StringBuilder ans = new StringBuilder();

        for (int i=s.length()-1, j; i>=0; i--) {
            if (s.charAt(i) != ' ') {
                j = i;
                i = s.lastIndexOf(' ', i);
                ans.append(s, i+1, j+1).append(" ");
            }
        }

        return ans.toString().trim();
    }
}
