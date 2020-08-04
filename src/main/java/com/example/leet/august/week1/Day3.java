package com.example.leet.august.week1;

import com.example.leet.util.MyFormatter;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 *
 * Constraints:
 *
 * s consists only of printable ASCII characters.
 */
public class Day3 {
    private static final Logger LOGGER = Logger.getLogger(Day3.class.getName());
    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end){
            if (!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            } else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new MyFormatter());
        LOGGER.addHandler(handler);
        LOGGER.info(String.valueOf(isPalindrome("A man, a plan, a canal: Panama")));     //true
        LOGGER.info(String.valueOf(isPalindrome("race a car")));     //false
        LOGGER.info(String.valueOf(isPalindrome("mom")));        //true
        LOGGER.info(String.valueOf(isPalindrome("Anna")));       //true
        LOGGER.info(String.valueOf(isPalindrome("   ")));        //true
        LOGGER.info(String.valueOf(isPalindrome("")));           //true
        LOGGER.info(String.valueOf(isPalindrome(".,")));         //true
        LOGGER.info(String.valueOf(isPalindrome(".")));          //true
        LOGGER.info(String.valueOf(isPalindrome1(".")));          //true
    }

    public static boolean isPalindrome1(String s) {
        if (s.length() == 0) return true;
        //initialize two pointers
        int i = 0;
        int j = s.length()-1;

        while (i < j) {

            char first = s.charAt(i);
            char second = s.charAt(j);

            int aDifference = first - 'a';
            int ADifference = first - 'A';
            int digitDifference = first - '0';

            int aDifference1 = second - 'a';
            int ADifference1 = second - 'A';
            int digitDifference1 = second - '0';

            if ((aDifference < 0 || aDifference >= 26) && (ADifference < 0 || ADifference >=26) && (digitDifference <0 || digitDifference >9)) {
                i++;
                continue;
            }

            if ((aDifference1 < 0 || aDifference1 >= 26) && (ADifference1 < 0 || ADifference1 >=26) && (digitDifference1 <0 || digitDifference1 >9)) {
                j--;
                continue;
            }

            if (aDifference >= 0 && aDifference < 26) {
                if (aDifference != aDifference1 && aDifference != ADifference1) return false;
            } else if (ADifference >= 0 && ADifference < 26) {
                if (ADifference != aDifference1 && ADifference != ADifference1) return false;
            } else {
                if (digitDifference != digitDifference1) return false;
            }

            i++;
            j--;
        }

        return true;
    }

}

