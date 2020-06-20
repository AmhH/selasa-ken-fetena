package com.example.leet.june.week3;

import java.util.HashSet;

/**
 * Longest Duplicate Substring
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
 * (The occurrences may overlap.)
 *
 * Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring,
 * the answer is "".)
 *
 * Example 1:
 *
 * Input: "banana"
 * Output: "ana"
 * Example 2:
 *
 * Input: "abcd"
 * Output: ""
 *
 * Note:
 *
 * 2 <= S.length <= 10^5
 * S consists of lowercase English letters.
 *    Hide Hint #1
 * Binary search for the length of the answer. (If there's an answer of length 10, then there are answers of length
 * 9, 8, 7, ...)
 *    Hide Hint #2
 * To check whether an answer of length K exists, we can use Rabin-Karp 's algorithm.
 * https://leetcode.com/problems/longest-duplicate-substring/discuss/694963/Beats-100-using-Trie-tree
 * https://www.youtube.com/watch?v=BMvotl5vHvM&feature=youtu.be
 */
public class Day19 {
    private String S;

    // T = O(N*K), S = O(N), where N is length of S and K avg depth of trie.
    public String longestDupSubstring(String S) {
        this.S = S;
        int maxLo = 0, maxLength = 0;
        TrieNode root = new TrieNode(0, 0);
        for (int i = 1; i + maxLength < S.length(); i++) {
            int len = addNew(root, i);
            if (len > maxLength) {
                maxLength = len;
                maxLo = i;
            }
        }
        return S.substring(maxLo, maxLo + maxLength);
    }

    private boolean isLeaf(TrieNode node) {
        return node.next == null;
    }

    private int getIndex(int i, int depth) {
        return S.charAt(i + depth) - 'a';
    }

    private int addNew(TrieNode node, int i) {
        int depth = node.depth;
        if (i + depth == S.length()) return depth;
        if (isLeaf(node)) {
            node.next = new TrieNode[26];
            node.next[getIndex(node.i, node.depth)] = new TrieNode(node.i, depth + 1);
        }
        int c = getIndex(i, node.depth);
        TrieNode x = node.next[c];
        if (x == null) {
            node.next[c] = new TrieNode(i, depth + 1);
            return depth;
        }
        return addNew(x, i);
    }

    private static class TrieNode {
        private TrieNode[] next;
        private int i;
        private int depth;

        public TrieNode(int i, int depth) {
            this.i = i;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Day19().longestDupSubstring("banana"));
        System.out.println(new Day19().longestDupSubstring("abcd"));
    }

    class Solution {
        /*
        Rabin-Karp with polynomial rolling hash.
            Search a substring of given length
            that occurs at least 2 times.
            Return start position if the substring exits and -1 otherwise.
            */
        public int search(int L, int a, long modulus, int n, int[] nums) {
            // compute the hash of string S[:L]
            long h = 0;
            for(int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

            // already seen hashes of strings of length L
            HashSet<Long> seen = new HashSet();
            seen.add(h);
            // const value to be used often : a**L % modulus
            long aL = 1;
            for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

            for(int start = 1; start < n - L + 1; ++start) {
                // compute rolling hash in O(1) time
                h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
                h = (h + nums[start + L - 1]) % modulus;
                if (seen.contains(h)) return start;
                seen.add(h);
            }
            return -1;
        }

        public String longestDupSubstring(String S) {
            int n = S.length();
            // convert string to array of integers
            // to implement constant time slice
            int[] nums = new int[n];
            for(int i = 0; i < n; ++i) nums[i] = (int)S.charAt(i) - (int)'a';
            // base value for the rolling hash function
            int a = 26;
            // modulus value for the rolling hash function to avoid overflow
            long modulus = (long)Math.pow(2, 32);

            // binary search, L = repeating string length
            int left = 1, right = n;
            int L;
            while (left <= right) {
                L = left + (right - left) / 2;
                if (search(L, a, modulus, n, nums) != -1) left = L + 1;
                else right = L - 1;
            }

            int start = search(left - 1, a, modulus, n, nums);
            return S.substring(start, start + left - 1);
        }
    }
}
