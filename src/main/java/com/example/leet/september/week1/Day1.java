package com.example.leet.september.week1;

/**
 * Largest Time for Given Digits
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time
 * has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 * Example 1:
 * Input: [1,2,3,4]
 * Output: "23:41"
 *
 * Example 2:
 * Input: [5,5,5,5]
 * Output: ""
 *
 * Note:
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 */
public class Day1 {

    private int maxTime = -1;

    public String largestTimeFromDigits(int[] A) {
        this.maxTime = -1;
        permutate(A, 0);
        if (this.maxTime == -1)
            return "";
        else
            return String.format("%02d:%02d", maxTime / 60, maxTime % 60);
    }

    protected void permutate(int[] array, int start) {
        if (start == array.length) {
            this.buildTime(array);
            return;
        }
        for (int i = start; i < array.length; ++i) {
            this.swap(array, i, start);
            this.permutate(array, start + 1);
            this.swap(array, i, start);
        }
    }

    protected void buildTime(int[] perm) {
        int hour = perm[0] * 10 + perm[1];
        int minute = perm[2] * 10 + perm[3];
        if (hour < 24 && minute < 60)
            this.maxTime = Math.max(this.maxTime, hour * 60 + minute);
    }

    protected void swap(int[] array, int i, int j) {
        if (i != j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Day1().largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        System.out.println(new Day1().new Solution().largestTimeFromDigits(new int[]{1, 2, 3, 4}));
        System.out.println(new Day1().largestTimeFromDigits(new int[]{5, 5, 5, 5}));
        System.out.println(new Day1().largestTimeFromDigits(new int[]{9, 3, 5, 2}));
    }

    class Solution {
        public String largestTimeFromDigits(int[] A) {
            StringBuilder result = new StringBuilder();
            int sixGtCount = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] >= 6)
                    sixGtCount++;
            }
            int maxHour = sixGtCount == 2 ? 1 : 2;
            // The first hour digit can only be a zero, 1, or 2.
            // Start by searching for the 2
            boolean firstHourSet = false;

            int hd = -1;
            outerhour:
            for (int hourDig = maxHour; hourDig >= 0; hourDig--) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == hourDig) {

                        result.append(hourDig);
                        hd = hourDig;
                        A[i] = -1;
                        firstHourSet = true;
                        break outerhour;
                    }
                }
            }

            if(! firstHourSet)
                return "";

            // The second hour digit can only be a zero, 1, or 2, or 3
            // Start by searching for the 3

            int sd = hd == 2 ? 3 : 9;

            boolean secondDigSet = false;
            outersd:
            for (int secondDig = sd; secondDig >= 0; secondDig--) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == secondDig) {

                        result.append(secondDig);
                        secondDigSet = true;
                        A[i] = -1;
                        break outersd;
                    }
                }
            }

            if(! secondDigSet)
                return "";
            result.append(":");

            // The first minute digit can only be a zero -> 5
            // Start by searching for down from 5

            boolean firstMinSet = false;
            outermin:
            for (int firstMin = 5; firstMin >= 0; firstMin--) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == firstMin) {

                        result.append(firstMin);
                        A[i] = -1;
                        firstMinSet = true;
                        break outermin;
                    }
                }
            }

            if(! firstMinSet)
                return "";


            for (int i : A) {
                if (i != -1) {
                    result.append(i);
                }
            }
            return result.toString();
        }
    }
}
