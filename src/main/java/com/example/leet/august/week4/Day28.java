package com.example.leet.august.week4;

/**
 *  Implement Rand10() Using Rand7()
 * Given the API rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which
 * generates a uniform random integer in the range 1 to 10. You can only call the API rand7 and you shouldn't call
 * any other API. Please don't use the system's Math.random().
 *
 * Notice that Each test case has one argument n, the number of times that your implemented function rand10 will be
 * called while testing.
 *
 * Follow up:
 *
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: [2]
 * Example 2:
 *
 * Input: n = 2
 * Output: [2,8]
 * Example 3:
 *
 * Input: n = 3
 * Output: [3,8,10]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 */
public class Day28 {

    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     *
     * A table is used to illustrate the concept of rejection sampling. Calling rand7() twice will get us row and
     * column index that corresponds to a unique position in the table above. Imagine that you are choosing a number
     * randomly from the table above. If you hit a number, you return that number immediately. If you hit a * , you
     * repeat the process again until you hit a number.
     *
     * Since 49 is not a multiple of 10, we have to use rejection sampling. Our desired range is integers from 1 to
     * 40, which we can return the answer immediately. If not (the integer falls between 41 to 49), we reject it and
     * repeat the whole process again.
     */
    public int rand10() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    public int rand102() {
        int a, b, idx;
        while (true) {
            a = rand7();
            b = rand7();
            idx = b + (a - 1) * 7;
            if (idx <= 40)
                return 1 + (idx - 1) % 10;
            a = idx - 40;
            b = rand7();
            // get uniform dist from 1 - 63
            idx = b + (a - 1) * 7;
            if (idx <= 60)
                return 1 + (idx - 1) % 10;
            a = idx - 60;
            b = rand7();
            // get uniform dist from 1 - 21
            idx = b + (a - 1) * 7;
            if (idx <= 20)
                return 1 + (idx - 1) % 10;
        }
    }

    private int rand7(){
        return (int) (Math.random() * 7);
    }
}
