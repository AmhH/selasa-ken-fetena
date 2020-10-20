package com.example.leet.practice.calc;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k){
       int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i+k)% nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        rotate(array, 3);
        System.out.println(Arrays.toString(array));
    }
}
