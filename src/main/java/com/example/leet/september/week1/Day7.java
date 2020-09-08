package com.example.leet.september.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in
 * str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated
 * by a single space.
 */
public class Day7 {
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        Map<Object, Integer> map = new HashMap<>();
        if(words.length != pattern.length())
            return false;
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if(!map.containsKey(c))
                map.put(c, i);
            if(!map.containsKey(word))
                map.put(word, i);
            if(!map.get(c).equals(map.get(word)))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
       /* System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));*/
        String pattern =
                "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String str = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s" +
                " s s s s s " +
                "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s " +
                "s s s s s s s s s s s s s s s s s s s s s s s s t t";

        System.out.println(wordPattern(pattern, str));
    }
}
