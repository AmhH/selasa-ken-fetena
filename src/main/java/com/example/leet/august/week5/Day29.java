package com.example.leet.august.week5;

import java.util.ArrayList;
import java.util.List;

/**
 *  Pancake Sorting
 * Given an array of integers A, We need to sort the array performing a series of pancake flips.
 *
 * In one pancake flip we do the following steps:
 *
 * Choose an integer k where 0 <= k < A.length.
 * Reverse the sub-array A[0...k].
 * For example, if A = [3,2,1,4] and we performed a pancake flip choosing k = 2, we reverse the sub-array [3,2,1], so
 * A = [1,2,3,4] after the pancake flip at k = 2.
 *
 * Return an array of the k-values of the pancake flips that should be performed in order to sort A. Any valid answer
 * that sorts the array within 10 * A.length flips will be judged as correct.
 *
 * Example 1:
 *
 * Input: A = [3,2,4,1]
 * Output: [4,2,4,3]
 * Explanation:
 * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
 * Starting state: A = [3, 2, 4, 1]
 * After 1st flip (k = 4): A = [1, 4, 2, 3]
 * After 2nd flip (k = 2): A = [4, 1, 2, 3]
 * After 3rd flip (k = 4): A = [3, 2, 1, 4]
 * After 4th flip (k = 3): A = [1, 2, 3, 4], which is sorted.
 * Notice that we return an array of the chosen k values of the pancake flips.
 * Example 2:
 *
 * Input: A = [1,2,3]
 * Output: []
 * Explanation: The input is already sorted, so there is no need to flip anything.
 * Note that other answers, such as [3, 3], would also be accepted.
 *
 * Constraints:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i] <= A.length
 * All integers in A are unique (i.e. A is a permutation of the integers from 1 to A.length).
 */
public class Day29 {

    /**
     * sort like bubble-sort i.e. sink the largest number to the bottom at each round.
     */
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();

        for (int valueToSort = A.length; valueToSort > 0; valueToSort--) {
            // locate the position for the value to sort in this round
            int index = this.find(A, valueToSort);

            // sink the value_to_sort to the bottom,
            // with at most two steps of pancake flipping.
            if (index == valueToSort - 1)
                continue;
            // 1). flip the value to the head if necessary
            if (index != 0) {
                ans.add(index + 1);
                this.flip(A, index + 1);
            }
            // 2). now that the value is at the head, flip it to the bottom
            ans.add(valueToSort);
            this.flip(A, valueToSort);
        }

        return ans;
    }

    protected void flip(int[] sublist, int k) {
        int i = 0;
        while (i < k / 2) {
            int temp = sublist[i];
            sublist[i] = sublist[k - i - 1];
            sublist[k - i - 1] = temp;
            i += 1;
        }
    }

    protected int find(int[] a, int target) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == target)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Day29().pancakeSort(new int[]{3,2,4,1}));
        System.out.println(new Day29().pancakeSort(new int[]{1,2,3}));
    }
}
