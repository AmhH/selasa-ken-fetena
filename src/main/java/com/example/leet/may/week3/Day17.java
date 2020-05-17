package com.example.leet.may.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Day17 {

    public static List<Integer> findAnagrams(String s, String p) {
        int[] alphabets = new int[26];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            alphabets[p.charAt(i) - 'a']++;
        }

        int start = 0, end = 0;
        while (end < s.length()){
            if(alphabets[s.charAt(end) - 'a'] > 0){
                alphabets[s.charAt(end++) - 'a']--;
                if(end - start == p.length()){
                    list.add(start);
                }
            } else if(start == end){
                start++;
                end++;
            }else{
                alphabets[s.charAt(start++)-'a']++;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
        System.out.println(findAnagrams("abab","ab"));
    }
}
