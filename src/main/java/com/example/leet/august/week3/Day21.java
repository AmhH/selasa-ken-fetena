package com.example.leet.august.week3;

import java.util.Arrays;

/**
 * Sort Array By Parity
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by
 * all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class Day21 {
    public static int[] sortArrayByParity(int[] A) {
        if(null == A || A.length < 2)
            return A;
        int even = 0;
        int odd = A.length - 1;
        int[] res = new int[A.length];
        for(int i : A){
            if(i%2 == 0){
                res[even++] = i;
            }else{
                res[odd--] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParity1(new int[]{5,3,1,2,4})));
    }

    public static int[] sortArrayByParity1(int[] A) {
        int indx = 0, val;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) != 1) {
                val = A[indx];
                A[indx] = A[i];
                A[i] = val;
                indx++;
            }
        }
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}
