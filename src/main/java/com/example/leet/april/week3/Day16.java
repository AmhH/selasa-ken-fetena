package com.example.leet.april.week3;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Valid Parenthesis String
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class Day16 {
    public static boolean checkValidString(String s) {

        Deque<Integer> paraStack = new LinkedList<>();
        Deque<Integer> starStack = new LinkedList<>();

        for(int i = 0 ; i< s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(')
                paraStack.push(i);
            else if(ch == '*')
                starStack.push(i);
            else{
                if(!paraStack.isEmpty())
                    paraStack.pop();
                else if(!starStack.isEmpty())
                    starStack.pop();
                else
                    return false;
            }
        }

        while(!paraStack.isEmpty()&& !starStack.isEmpty()){
            if(paraStack.pop() > starStack.pop())
                return false;
        }
        return paraStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
    }
}
