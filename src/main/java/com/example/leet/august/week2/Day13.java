package com.example.leet.august.week2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Iterator for Combination
 * Design an Iterator class, which has:
 *
 * A constructor that takes a string characters of sorted distinct lowercase English letters and a number
 * combinationLength as arguments.
 * A function next() that returns the next combination of length combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next combination.
 *
 *
 * Example:
 *
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
 *
 * iterator.next(); // returns "ab"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc"
 * iterator.hasNext(); // returns false
 *
 *
 * Constraints:
 *
 * 1 <= combinationLength <= characters.length <= 15
 * There will be at most 10^4 function calls per test.
 * It's guaranteed that all calls of the function next are valid.
 *    Hide Hint #1
 * Generate all combinations as a preprocessing.
 *    Hide Hint #2
 * Use bit masking to generate all the combinations.
 */
public class Day13 {
    static class CombinationIterator {
        private Queue<String> queue;
        public CombinationIterator(String characters, int combinationLength) {
            this.queue = new LinkedList<>();
            generateCombination(characters, 0, "", combinationLength, queue);
        }

        private void generateCombination(String characters, int start, String soFar, int length,
                                         Queue<String> queue) {
            if(length == 0){
                queue.add(soFar);
                return;
            }
            for(int i = start; i < characters.length(); i++) {
                generateCombination(characters, i + 1, soFar + characters.charAt(i), start - 1, queue);
            }
        }

        public String next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    class CombinationIterator2 {

        Queue<String> queue;

        public CombinationIterator2(String characters, int combinationLength) {
            queue = new LinkedList();
            combinations(characters, 0, "", combinationLength, queue);
        }

        public void combinations(String characters, int start, String soFar, int k, Queue<String> queue) {
            if (k == 0) {
                queue.add(soFar);
                return;
            }

            for(int i = start; i < characters.length(); i++) {
                combinations(characters, i + 1, soFar + characters.charAt(i), k - 1, queue);
            }
        }

        public String next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2);
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    class CombinationIterator10 {
        private String chars;
        private int[] pos;
        private boolean hasNext;

        public CombinationIterator10(String characters, int combinationLength) {
            hasNext = true;
            chars = characters;
            pos = new int[combinationLength];
            for(int i = 0; i < combinationLength; i++) {
                pos[i] = i;
            }
        }

        public String next() {
            StringBuilder b = new StringBuilder();
            for(int i = 0; i < pos.length; i++) {
                b.append(chars.charAt(pos[i]));
            }

            int n = chars.length();
            hasNext = false;
            for(int i = pos.length - 1; i >= 0; i--) {
                if(n - pos[i] > pos.length - i) {
                    pos[i]++;
                    for(int j = i+1; j < pos.length; j++) {
                        pos[j] = pos[j-1]+1;
                    }
                    hasNext =  true;
                    break;
                }
            }

            return b.toString();
        }

        public boolean hasNext() {
            return hasNext;
        }
    }

    class CombinationIterator9 {
        char[] cur, dic;
        boolean hasNext;
        int n;
        public CombinationIterator9(String characters, int L) {
            cur = characters.substring(0, L).toCharArray();
            dic = characters.toCharArray();
            n = dic.length;
            hasNext = true;
        }

        public String next() {
            if(!hasNext) return "";
            String res = new String(cur);
            int L = cur.length;
            int i = cur.length - 1, j = dic.length - 1;
            while(i >= 0 && cur[i] == dic[j]){
                i--;
                j--;
            }
            if(i == -1){
                hasNext = false;
            }else{
                int index = String.valueOf(dic).indexOf(cur[i]);
                for( int k = i; k < L; k++) {
                    cur[k] = dic[++index];
                }
            }
            return res;
        }

        public boolean hasNext() {
            return hasNext;
        }
    }

}
