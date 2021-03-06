package com.example.leet.may.week1;

/**
 * First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class Day5 {
    public static int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("cc"));
    }
}
