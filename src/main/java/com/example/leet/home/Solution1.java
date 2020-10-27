package com.example.leet.home;

import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public static int maxTrailing(List<Integer> levels) {
        // Write your code here
        if(null == levels || levels.isEmpty())
            return -1;
        int currentMin = levels.get(0);
        int max = -1;
        for(int i = 1; i < levels.size(); i++){
            int current = levels.get(i);
            if(current > currentMin && max < (current - currentMin)){
                max = current - currentMin;
            }else if(current < currentMin){
                currentMin = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxTrailing(Arrays.asList(2, 3, 10, 2, 4, 8, 1)));
    }
}
