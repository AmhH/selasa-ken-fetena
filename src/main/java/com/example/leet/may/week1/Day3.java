package com.example.leet.may.week1;

import java.util.HashMap;
import java.util.Map;

/**
 *Ransom Note
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
 * that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Day3 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            charCount.put(magazine.charAt(i), charCount.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            Integer count = charCount.get(ransomNote.charAt(i));
            if(count == null || count.equals(0))
                return false;
            charCount.put(ransomNote.charAt(i), count - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b")); //-> false
        System.out.println(canConstruct("aa", "ab")); //-> false
        System.out.println(canConstruct("aa", "aab")); //-> true
    }

    private static final int R = 26;

    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] pool = new int[R];

        for (char c : ransomNote.toCharArray()) pool[c - 'a'] -= 1;

        for (char c : magazine.toCharArray()) pool[c - 'a'] += 1;

        for (int i = 0; i < R; i += 1) if (pool[i] < 0) return false;

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] record = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            record[c - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            --record[c - 'a'];
            if (record[c - 'a'] < 0) {
                return false;
            }
        }

        return true;

    }

    public boolean canConstruct3(String ransomNote, String magazine) {
        /// 1ms, 99.65%
        if (ransomNote.length() > magazine.length()) return false;

        int[] chars = new int[26];
        int counts = 0;
        for (int i = 0; i < ransomNote.length(); i++)
        {
            int index = ransomNote.charAt(i) - 'a';
            if (chars[index] == 0) counts++;
            chars[index]++;
        }

        for (int i = 0; i < magazine.length(); i++)
        {
            int index = magazine.charAt(i) - 'a';
            if (chars[index] == 1) counts--;
            if (counts == 0) return true;
            chars[index]--;
        }

        return counts == 0;
    }
}
