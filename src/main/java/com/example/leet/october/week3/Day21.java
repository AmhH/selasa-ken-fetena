package com.example.leet.october.week3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Asteroid Collision
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning
 * right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If
 * both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 * Example 4:
 *
 * Input: asteroids = [-2,-1,1,2]
 * Output: [-2,-1,1,2]
 * Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same
 * direction never meet, so no asteroids will meet each other.
 *
 * Constraints:
 *
 * 1 <= asteroids <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 *    Hide Hint #1
 * Say a row of asteroids is stable. What happens when a new asteroid is added on the right?
 */
public class Day21 {
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> s = new LinkedList<>();
        for(int i: asteroids){
            if(i > 0){
                s.push(i);
            }else{// i is negative
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)){
                    s.pop();
                }
                if(s.isEmpty() || s.peek() < 0){
                    s.push(i);
                }else if(i + s.peek() == 0){
                    s.pop(); //equal
                }
            }
        }
        int[] res = new int[s.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = s.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5,10,-5})));//[5,10]
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8,-8})));//[]
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10,2,-5})));//[10]
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2,-1,1,2})));//[-2,-1,1,2]
    }

    public int[] asteroidCollision1(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return null;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            if (a > 0) {
                stack.addLast(a);
            } else if (a < 0) {
                boolean isExploded = false;
                while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() <= -a) {
                    int temp = stack.removeLast();
                    if (temp == -a) {
                        isExploded = true;
                        break;
                    }
                }
                if ((stack.isEmpty() || stack.peekLast() < 0) && !isExploded) {
                    stack.addLast(a);
                }

            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; --i) {
            res[i] = stack.removeLast();
        }

        return res;
    }

    public int[] asteroidCollision2(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return null;
        }

        // two pointers
        // let end be a pointer such that asteroids[end] contains the asteroids that is safe for now
        // if asteroids[end] is negative and asteroids[i] is positive, then put i to end + 1, and update end to end + 1
        // if asteroids[end] and asteroids [i] are both negative or position, put i to end + 1 and update end to end + 1
        // if asteroids[end] is positive and asteroids[i] is negative,
        //    while (end >= 0 && asteroids[end] <= -asteroids[i]) end--

        int end = 0;
        for (int i = 1; i < asteroids.length; ++i) {
            if (asteroids[i] > 0) {
                asteroids[++end] = asteroids[i];
            } else if (asteroids[i] < 0) {
                boolean isExploded = false;
                while (end >= 0 && asteroids[end] > 0 && asteroids[end] <= -asteroids[i]) {
                    int temp = asteroids[end--];
                    if (temp == -asteroids[i]) {
                        isExploded = true;
                        break;
                    }
                }
                if ((end < 0 || asteroids[end] < 0) && !isExploded) {
                    asteroids[++end] = asteroids[i];
                }
            }
        }
        int[] res = new int[end + 1];
        for (int i = 0; i < end + 1; ++i) {
            res[i] = asteroids[i];
        }
        return res;
    }
}
