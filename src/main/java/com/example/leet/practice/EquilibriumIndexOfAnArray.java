package com.example.leet.practice;

/**
 * Write a program to find the equilibrium index of an array. Equilibrium index of an array is an index such that sum
 * of elements at lower indexes = sum of elements at higher indexes.
 * Input: A[] = {-7, 1, 5, 2, -4, 3, 0}
 * Output: 3
 * Explanation: 3 is an equilibrium index, because:
 * a[0] + a[1] + a[2] = a[4] + a[5] + a[6]
 */
public class EquilibriumIndexOfAnArray {

    public static int equilibriumIndex(int[] a){
        int leftSum = 0;
        int totalSum = 0;

        for(int i : a){
            totalSum += i;
        }

        for (int i = 0; i < a.length; i++) {
            totalSum -= a[i];
            int rightSum = totalSum;
            if(leftSum == rightSum){
                return i;
            }
            leftSum += a[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(equilibriumIndex(new int[]{-7, 1, 5, 2, -4, 3, 0}));
        System.out.println(equilibriumIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));


    }
}
