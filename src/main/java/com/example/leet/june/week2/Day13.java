package com.example.leet.june.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Largest Divisible Subset
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in
 * this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class Day13 {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums==null||nums.length==0)
            return new ArrayList<>();

        int len = nums.length;
        Arrays.sort(nums);
        //dp[i] stores the max len list ends in dp[i], initial = 1
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int maxLen=1; //store max list len
        int maxNum=nums[0]; //store the max num in this longest divisible list
        //update dp, see if there's any other elements can be divided by nums[i]
        for(int i=1;i<len;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0)
                {
                    dp[i] = Math.max(dp[i],1+dp[j]);
                    if(dp[i]>maxLen)
                    {
                        maxNum = nums[i];
                        maxLen = dp[i];
                    }
                }
            }
        }

        List<Integer> rst = new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            if(maxNum%nums[i]==0)
            {
                rst.add(nums[i]);
                if(rst.size()==maxLen)
                    break;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[] {1,2,3}));
        System.out.println(largestDivisibleSubset(new int[] {1,2,4,8}));
        System.out.println(largestDivisibleSubset(new int[] {1,4,2,6,7}));
    }

    class Solution {
        int maxV;
        int maxL;
        int cs;
        int next[];
        int len[];
        public List<Integer> largestDivisibleSubset(int[] nums) {

            if(nums.length==0)
                return new ArrayList<>();

            next=new int[nums.length];
            len=new int[nums.length];

            Arrays.sort(nums);
            maxV=nums[nums.length-1];


            for(int j=0;j<nums.length;j++){
                dp(1,j,nums);
            }

            List<Integer>list=new ArrayList<>();
            int i=cs;
            while(i!=-1){
                list.add(nums[i]);
                i=next[i];
            }
            return list;

        }

        private void dp(int cL,int start,int[] nums){

            if(len[start]==0){
                len[start]=1;
                next[start]=-1;
            }
            if(len[start]>maxL){
                maxL=len[start];
                cs=start;
            }

            int limit=maxV>>Math.max(maxL-cL,0);
            int max=0;
            for(int j=start+1;j<nums.length&&nums[j]<=limit;j++){

                if(nums[j]%nums[start]==0){

                    if(len[j]==0){
                        dp(cL+1,j,nums);
                    }

                    if(len[j]>max){
                        max=len[j];
                        next[start]=j;
                        len[start]=len[j]+1;
                        if(len[start]>maxL){
                            maxL=len[start];
                            cs=start;
                            limit=maxV>>Math.max(0,maxL-cL);
                        }
                    }
                }
            }
        }
    }
}
