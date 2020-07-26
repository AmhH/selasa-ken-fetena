package com.example.leet.july.week4;

/**
 * Add Digits
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 *    Hide Hint #1
 * A naive implementation of the above process is trivial. Could you come up with other methods?
 *    Hide Hint #2
 * What are all the possible results?
 *    Hide Hint #3
 * How do they occur, periodically or randomly?
 *    Hide Hint #4
 * You may find this Wikipedia article useful.
 */
public class Day26 {
    public static int addDigits(int num) {
        if(num == 0)
            return num;
        return 1 + ((num - 1) % 9);// 1 + ((num - 1) % (base -1));
    }

    public static void main(String[] args) {
        System.out.println(addDigits(0));
        System.out.println(addDigits(9));
        System.out.println(addDigits(10));
        System.out.println(addDigits(456678));
        System.out.println(addDigits(29));
    }
}
