package com.example.leet.june.week1;

import java.util.Arrays;

/**
 *  Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * Hide Hint #1
 * The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
 */
public class Day4 {


    public static void main(String[] args) {
        char[] chars = {'h','e','l','l','o'};
        char[] chars1 = {'H','a','n','n','a','h'};
        reverseString(chars);
        reverseString2(chars1);
        System.out.println(Arrays.toString(chars));
        System.out.println(Arrays.toString(chars1));
    }
}
