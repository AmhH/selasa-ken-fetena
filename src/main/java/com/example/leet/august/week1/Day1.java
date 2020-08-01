package com.example.leet.august.week1;

/**
 * Detect Capital
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * Example 1:
 * Input: "USA"
 * Output: True
 *
 * Example 2:
 * Input: "FlaG"
 * Output: False
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class Day1 {

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        boolean upperCase = Character.isUpperCase(word.charAt(0));
        char[] chars = word.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if(upperCase && i == 1){
                upperCase = Character.isUpperCase(chars[i]);
                continue;
            }
            if (upperCase != Character.isUpperCase(chars[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("leetCode"));
        System.out.println(detectCapitalUse1("Google"));
    }

    public static boolean detectCapitalUse1(String word) {
        int lastCap = -1;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                if(lastCap + 1 == i) {
                    lastCap++;
                } else {
                    return false;
                }
            }
        }

        if(lastCap == -1 || lastCap == word.length() - 1 || lastCap == 0) {
            return true;
        }

        return false;
    }
}
