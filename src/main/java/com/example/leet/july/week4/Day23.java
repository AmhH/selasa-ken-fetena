package com.example.leet.july.week4;

import java.util.Arrays;

/**
 * Single Number III
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear
 * exactly twice. Find the two elements that appear only once.
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 * <p>
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * <p>
 * [VISUALIZATION]
 * honestly, i really spent a lot of time to understand this. here is the visualization that i hope latecomers get
 * the idea
 * <p>
 * first run ^ to get the a^b
 * search the position to do partitioning in binary representation of a^b
 * partition the array by this position and get a and b correspondingly
 * e.g. [1,2,1,3,2,5]
 * <p>
 * 1 = 001
 * 2 = 010
 * 1 = 001
 * 3 = 011
 * 2 = 010
 * 5 = 101
 * <p>
 * after 1st step, we found out that a^b = 3^5 = 6 which is 110
 * 110 means that there are 2 digits on the left are different in binary representation of our result
 * let's use any one of the digit to partition our array
 * <p>
 * if we use the middle one, we can see that there are 2 sets of numbers that we can just use the simple single
 * number to find out the single in each partition
 * 1 = 001
 * 1 = 001
 * 5 = 101 ✅
 * 2 = 010
 * 2 = 010
 * 3 = 011 ✅
 * <p>
 * if we use the leftmost one, we can still partition the array into the sets and do simple single number on it
 * 1 = 001
 * 2 = 010
 * 1 = 001
 * 3 = 011✅
 * 2 = 010
 * 5 = 101✅
 */
public class Day23 {

}
