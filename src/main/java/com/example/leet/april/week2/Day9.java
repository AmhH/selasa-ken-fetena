package com.example.leet.april.week2;

/**
 * Backspace String Compare
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a
 * backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class Day9 {

    public static boolean backspaceCompare(String S, String T) {
        if (S.isEmpty() && T.isEmpty()) {
            return true;
        }
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (true) {
            i = applyBackSpace(S, i);
            j = applyBackSpace(T, j);
            if (i < 0 && j < 0) {
                return true;
            }
            if (i < 0 || j < 0 || S.charAt(i--) != T.charAt(j--)) {
                return false;
            }
        }
    }

    private static int applyBackSpace(String str, int i) {
        int count = 0;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                count++;
            } else if (count > 0) {
                count--;
            } else if (count == 0) {
                break;
            }
            i--;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c","ad#c"));
        System.out.println(backspaceCompare("ab##","c#d#"));
        System.out.println(backspaceCompare("a##c","#a#c"));
        System.out.println(backspaceCompare("a#c","b"));
    }
}
