package com.example.leet.may.week3;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Online Stock Span
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and
 * going backwards) for which the price of the stock was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans
 * would be [1, 1, 1, 2, 1, 4, 6].
 *
 * Example 1:
 *
 * Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [null,1,1,1,2,1,4,6]
 * Explanation:
 * First, S = StockSpanner() is initialized.  Then:
 * S.next(100) is called and returns 1,
 * S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1,
 * S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1,
 * S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 *
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 *
 * Note:
 *
 * Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
 * There will be at most 10000 calls to StockSpanner.next per test case.
 * There will be at most 150000 calls to StockSpanner.next across all test cases.
 * The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 */
public class Day19 {

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));//1
        System.out.println(obj.next(80));//1
        System.out.println(obj.next(60));//1
        System.out.println(obj.next(70));//2
        System.out.println(obj.next(60));//1
        System.out.println(obj.next(75));//4
        System.out.println(obj.next(85));//6
    }

    static class StockSpanner {
        Stack<int[]> stack;
        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            while(!stack.isEmpty() && price >= stack.peek()[0]){
                span += stack.pop()[1];
            }
            stack.push(new int[]{price, span});
            return span;
        }
    }

    class StockSpanner1 {

        private int[] pricesStack;
        private int[] spansStack;
        private int top;

        public StockSpanner1() {
            pricesStack = new int[10000];
            spansStack = new int[10000];
            top = -1;
        }

        public int next(int price) {
            int span = 1;
            while (0 <= top && pricesStack[top] <= price) {
                span += spansStack[top--];
            }
            top++;
            pricesStack[top] = price;
            spansStack[top] = span;
            return span;
        }

    }

    static class StockSpanner2 {

        public StockSpanner2() {
            i=0;
            st=new LinkedList<>();
        }
        static LinkedList<int[]> st;
        static int i;
        public int next(int x) {
            while(!st.isEmpty() && st.getLast()[1] <= x) {
                st.removeLast();
            }
            int ai = st.isEmpty()?-1:st.getLast()[0];
            st.addLast(new int[]{i,x});
            return i++ -ai;
        }
    }
}
