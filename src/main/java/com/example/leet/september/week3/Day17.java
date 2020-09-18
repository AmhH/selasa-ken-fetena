package com.example.leet.september.week3;

/**
 * Robot Bounded In Circle
 * On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three
 * instructions:
 *
 * "G": go straight 1 unit;
 * "L": turn 90 degrees to the left;
 * "R": turn 90 degress to the right.
 * The robot performs the instructions given in order, and repeats them forever.
 *
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 *
 * Example 1:
 *
 * Input: "GGLLGG"
 * Output: true
 * Explanation:
 * The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 * When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 * Example 2:
 *
 * Input: "GG"
 * Output: false
 * Explanation:
 * The robot moves north indefinitely.
 * Example 3:
 *
 * Input: "GL"
 * Output: true
 * Explanation:
 * The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 *
 * Note:
 *
 * 1 <= instructions.length <= 100
 * instructions[i] is in {'G', 'L', 'R'}
 *    Hide Hint #1
 * Calculate the final vector of how the robot travels after executing all instructions once - it consists of a
 * change in position plus a change in direction.
 *    Hide Hint #2
 * The robot stays in the circle iff (looking at the final vector) it changes direction (ie. doesn't stay pointing
 * north), or it moves 0.
 */
public class Day17 {
    public static boolean isRobotBounded(String instructions) {
        int i=0;
        int j=0;
        int dir=1;

        for(char c : instructions.toCharArray()){  // Loop through to follow every instruction
            if(c == 'G'){
                if(dir == 1) j++;  //if direction is north, move forward
                else if(dir == 2) i++;  //if direction is East, move right
                else if(dir == 3) j--;  //if direction is South, move downward
                else i--;  //if direction is west, move West
            }
            else if(c == 'L'){  // if asked to turn left
                dir = dir == 1 ? 4 : dir-1; // subtract 1 from current direction to turn left, if  dir == 1 i.e. North, we need to turn towards west i.e. 4
            }
            else if(c == 'R'){ // if asked to turn right
                dir = dir == 4 ? 1 : dir+1;  // add 1 from current direction to turn right, if  dir == 4 i.e. West, we need to turn towards North i.e. 1
            }
        }

        return i == 0 && j == 0 || dir > 1;   // check the current position and direction and decide
    }

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));//true
        System.out.println(isRobotBounded("GG"));//false
        System.out.println(isRobotBounded("GL"));//true
    }
}
