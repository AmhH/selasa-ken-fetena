package com.example.leet.august.week3;

import java.util.Arrays;

/**
 * Distribute Candies to People
 * We distribute some number of candies, to a row of n = num_people people in the following way:
 *
 * We then give 1 candy to the first person, 2 candies to the second person, and so on until we give n candies to the
 * last person.
 *
 * Then, we go back to the start of the row, giving n + 1 candies to the first person, n + 2 candies to the second
 * person, and so on until we give 2 * n candies to the last person.
 *
 * This process repeats (with us giving one more candy each time, and moving to the start of the row after we reach
 * the end) until we run out of candies.  The last person will receive all of our remaining candies (not necessarily
 * one more than the previous gift).
 *
 * Return an array (of length num_people and sum candies) that represents the final distribution of candies.
 *
 * Example 1:
 *
 * Input: candies = 7, num_people = 4
 * Output: [1,2,3,1]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3,0].
 * On the fourth turn, ans[3] += 1 (because there is only one candy left), and the final array is [1,2,3,1].
 * Example 2:
 *
 * Input: candies = 10, num_people = 3
 * Output: [5,2,3]
 * Explanation:
 * On the first turn, ans[0] += 1, and the array is [1,0,0].
 * On the second turn, ans[1] += 2, and the array is [1,2,0].
 * On the third turn, ans[2] += 3, and the array is [1,2,3].
 * On the fourth turn, ans[0] += 4, and the final array is [5,2,3].
 *
 *
 * Constraints:
 *
 * 1 <= candies <= 10^9
 * 1 <= num_people <= 1000
 *    Hide Hint #1
 * Give candy to everyone each "turn" first [until you can't], then give candy to one person per turn.
 */
public class Day17 {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int i = 0; candies > 0; ++i) {
            res[i % num_people] += Math.min(candies, i + 1);
            candies -= i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));
        System.out.println(Arrays.toString(distributeCandies(10, 3)));
    }

    public static int[] distributeCandies2(int candies, int n) {
        int[] answer = new int[n];
        long num_people = n;
        if(candies == 0) return answer;
        int number = binarySearch(0, Math.min(50000, candies), candies) -1;
        int fullFills =(int) number/n;
        for(int i=1;i<=num_people;i++){
            answer[i-1] = (int) (fullFills*i + (int) ((((fullFills -1) * 1l*fullFills)*num_people)/2));
        }
        int current = (int) (fullFills*num_people + 1l);
        int candiesLeft = candies - (int) ((current-1) * current)/2;
        for(int i=1;i<=num_people;i++){
            int candiesToAdd = Math.min(current, candiesLeft);
            answer[i-1] = (int) answer[i-1] + candiesToAdd;
            candiesLeft -= candiesToAdd;
            current++;
        }
        System.out.println(candiesLeft);
        return answer;
    }

    static int binarySearch(int start, int end, int target){
        while(start < end){
            int mid = (start+end)/2;
            if((1l*mid*(mid+1l))/2l >= target){
                end = mid;
            }
            else{
                start = mid +1;
            }
        }
        return start;
    }
}
