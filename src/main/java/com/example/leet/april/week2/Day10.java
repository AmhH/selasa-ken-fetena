package com.example.leet.april.week2;

import java.util.Stack;

/**
 * Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 *    Show Hint #1
 *    Consider each node in the stack having a minimum value. (Credits to @aakarshmadhavan)
 */
public class Day10 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      // Returns 0.
        System.out.println(minStack.getMin());   // Returns -2.
    }
}

class MinStack {

    Stack<int[]> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int[] {x, x});
        }else{
            stack.push(new int[] {x, Math.min(stack.peek()[1], x)});
        }

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
