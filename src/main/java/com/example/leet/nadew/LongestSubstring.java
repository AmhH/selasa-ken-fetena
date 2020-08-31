package com.example.leet.nadew;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with same letter after replacement.
 */
public class LongestSubstring {
    public static int longestSubstringWithReplacement(String str, int k){
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int end = 0; end < str.length(); end++){
            map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0)+1);
            max = Math.max(max, map.get(str.charAt(end)));
            if(max + k < (end - start) + 1){
                map.put(str.charAt(start), map.get(str.charAt(start))-1);
                start++;
            }
        }
        return max + k;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithReplacement("baacbcbb", 2));//5
        System.out.println(longestSubstringWithReplacement("abbcb", 1));//4
    }
}
