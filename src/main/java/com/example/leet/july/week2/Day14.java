package com.example.leet.july.week2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Angle Between Hands of a Clock
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute
 * hand.
 *
 * Example 1:
 * Input: hour = 12, minutes = 30
 * Output: 165
 *
 * Example 2:
 * Input: hour = 3, minutes = 30
 * Output: 75
 *
 * Example 3:
 * Input: hour = 3, minutes = 15
 * Output: 7.5
 *
 * Example 4:
 * Input: hour = 4, minutes = 50
 * Output: 155
 *
 * Example 5:
 * Input: hour = 12, minutes = 0
 * Output: 0
 *
 * Constraints:
 *
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * Answers within 10^-5 of the actual value will be accepted as correct.
 *    Hide Hint #1
 * The tricky part is determining how the minute hand affects the position of the hour hand.
 *    Hide Hint #2
 * Calculate the angles separately then find the difference.
 */
public class Day14 {

    public static double angleClock(int hour, int minutes) {
        double minuteAngle = (360 / 60.0) * (minutes % 60);
        double hourAngle = ((360 / 12.0) * (hour % 12)) + ((5 / 60.0) * minutes % 12) *6;
        double angle = Math.abs(minuteAngle - hourAngle);
        return angle > 180.0 ? 360.0 - angle : angle;
    }

    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 30));
        System.out.println(angleClock(3, 15));
        System.out.println(angleClock(4, 50));
        System.out.println(angleClock(12, 0));
        System.out.println(angleClock(1, 57));
    }
}
