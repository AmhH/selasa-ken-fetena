package com.example.leet.august.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Random Point in Non-overlapping Rectangles
 * Given a list of non-overlapping axis-aligned rectangles rects, write a function pick which randomly and uniformily
 * picks an integer point in the space covered by the rectangles.
 *
 * Note:
 *
 * An integer point is a point that has integer coordinates.
 * A point on the perimeter of a rectangle is included in the space covered by the rectangles.
 * ith rectangle = rects[i] = [x1,y1,x2,y2], where [x1, y1] are the integer coordinates of the bottom-left corner,
 * and [x2, y2] are the integer coordinates of the top-right corner.
 * length and width of each rectangle does not exceed 2000.
 * 1 <= rects.length <= 100
 * pick return a point as an array of integer coordinates [p_x, p_y]
 * pick is called at most 10000 times.
 * Example 1:
 *
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[[[1,1,5,5]]],[],[],[]]
 * Output:
 * [null,[4,1],[4,1],[3,3]]
 * Example 2:
 *
 * Input:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * Output:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 * Explanation of Input Syntax:
 *
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the
 * array of rectangles rects. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 *
 *
 */
public class Day22 {
    class Solution {

        int[][] rects;
        List<Integer> psum = new ArrayList<>();
        int tot = 0;
        Random rand = new Random();
        public Solution(int[][] rects) {
            this.rects = rects;
            for (int[] x : rects) {
                tot += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
                psum.add(tot);
            }
        }

        public int[] pick() {
            int targ = rand.nextInt(tot);

            int lo = 0;
            int hi = rects.length - 1;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (targ >= psum.get(mid)) lo = mid + 1;
                else hi = mid;
            }

            int[] x = rects[lo];
            int width = x[2] - x[0] + 1;
            int height = x[3] - x[1] + 1;
            int base = psum.get(lo) - width * height;
            return new int[]{x[0] + (targ - base) % width, x[1] + (targ - base) / width};
        }
    }

}
