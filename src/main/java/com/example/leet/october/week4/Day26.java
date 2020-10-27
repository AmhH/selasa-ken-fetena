package com.example.leet.october.week4;

/**
 * Champagne Tower
 * We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the
 * 100th row.  Each glass holds one cup of champagne.
 *
 * Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid
 * poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full,
 * any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom
 * row has its excess champagne fall on the floor.)
 *
 * For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are
 * poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups
 * become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the
 * middle glass half full, and the two outside glasses are a quarter full, as pictured below.
 *
 * Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is
 * (both i and j are 0-indexed.)
 *
 *
 *
 * Example 1:
 *
 * Input: poured = 1, query_row = 1, query_glass = 1
 * Output: 0.00000
 * Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will
 * be no excess liquid so all the glasses under the top glass will remain empty.
 * Example 2:
 *
 * Input: poured = 2, query_row = 1, query_glass = 1
 * Output: 0.50000
 * Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is
 * one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid
 * equally, and each will get half cup of champange.
 * Example 3:
 *
 * Input: poured = 100000009, query_row = 33, query_glass = 17
 * Output: 1.00000
 *
 *
 * Constraints:
 *
 * 0 <= poured <= 109
 * 0 <= query_glass <= query_row < 100
 */
public class Day26 {

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[] res = new double[query_row + 2];
        res[0] = poured;
        for (int row = 1; row <= query_row; row++)
            for (int i = row; i >= 0; i--)
                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
        return Math.min(res[query_glass], 1.0);
    }

    public static void main(String[] args) {
        System.out.println(champagneTower(1,1,1));
        System.out.println(champagneTower(2,1,1));
        System.out.println(champagneTower(100000009,33,17));
    }

    public double champagneTower1(int poured, int query_row, int query_glass) {
        if (query_row == 0){
            return Math.min(1, poured);
        }
        if (poured <= 1){
            return 0;
        }
        var prev = new double[query_row + 1];
        var cur = new double[query_row + 1];

        var curRow = 1;
        prev[0] = poured - 1;
        var anyPositive = true;
        while (curRow <= query_row && anyPositive){
            anyPositive = false;
            var start = query_glass - query_row + curRow;
            start = start > 0 ? start : 0;
            var end = query_glass > curRow ? curRow : query_glass;
            for (var i = start; i <= end; i++) {
                var p = 0.0;
                if (i - 1 >= 0 && prev[i - 1] > 0) {
                    p += prev[i - 1] / 2;
                }
                if (i < curRow && prev[i] > 0) {
                    p += prev[i] / 2;
                }
                cur[i] = p - 1;
                anyPositive = anyPositive || (p > 1);
            }
            var t = cur;
            cur = prev;
            prev = t;
            curRow += 1;
        }
        if (!anyPositive && curRow <= query_row) {
            return .0;
        }
        return Math.min(1, prev[query_glass] + 1);
    }
}
