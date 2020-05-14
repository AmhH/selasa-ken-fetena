package com.example.leet.may.week2;

import java.util.Stack;

/**
 * Remove K Digits
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class Day13 {

    public static String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";

        StringBuilder sb = new StringBuilder(num);

        for (int j = 0; j < k; j++) {
            int i = 0;
            while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                i++;
            }
            sb.delete(i, i + 1);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.delete(0, 1);

        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }

    public String removeKdigits2(String num, int k) {

        // Add Character to stack if stack top element is greater than current element pop from stack
        // Pop from stack until k = 0

        int len = num.length();

        if(len <= k) return "0" ;

        // Remove prefixed zero

        // Return the string


        Stack<Character> stack = new Stack<>();
        int i = 0;

        while(i<len){

            // Continue to pop from stack
            //System.out.println("Stack -- " + stack);
            while(i < len && k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i++));
        }


        //System.out.println(stack);

        // Cases like 11111
        while(k>0){
            stack.pop(); k--;
        }

        // Remove zeroes from begining

        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            result.append(stack.pop());
        }

        result.reverse();
        // Remove
        i = 0 ;
        while( result.length() > 0 && result.charAt(0) == '0'){
            result.deleteCharAt(0);
        }

        return (result.length() == 0) ? "0" : result.toString();

    }

    public String removeKdigits3(String num, int k) {
        if (num==null || k<=0) return num;
        char[] c=num.toCharArray();
        int right=0;
        int left=0;
        while(right<c.length){
            if(left==0){
                if(c[right]=='0') // 3  <-0  : 30 (rather than 0)
                    right++;
                else // 3  <-1  : 1
                    c[left++]=c[right++];
            }
            else if(k>0 && c[left-1]>c[right]){
                left--;
                k--;
            }
            else {
                c[left++]=c[right++];
            }

        }
        while (k>0) {
            left--;
            k--;
        }
        return left<=0?"0":new String(c, 0, left);
    }
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); // 1219
        System.out.println(removeKdigits("10200", 1)); // 200
        System.out.println(removeKdigits("10", 2)); // 0
    }
}
