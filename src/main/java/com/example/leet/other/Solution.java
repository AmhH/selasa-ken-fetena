package com.example.leet.other;

import java.util.*;

public class Solution {
    public static void main(String[] argh) {
       Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();
            validParentheses(input);
        }

        Arrays.asList("(({()})))", "}}}}", "))))").forEach(Solution::validParentheses);

    }

    private static void validParentheses(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] c = input.toCharArray();
        for (char a : c) {
            if (a == '[' || a == '(' || a == '{') {
                stack.push(a);
            }else  if (a == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }else  if (a == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }else  if (a == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }else  if (a == ']' || a == ')' || a == '}') {
                stack.push(a);
                break;
            }
        }
        System.out.println(stack.isEmpty());
        stack.clear();
    }
}
