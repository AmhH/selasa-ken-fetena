package com.example.leet.september.week1;

import com.example.leet.nadew.LongestSubstring;
import com.example.leet.nadew.PartitionString;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition Labels
 *
 * Solution
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible
 * so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 *
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 *
 *
 *  Hide Hint #1
 *  Try to greedily choose the smallest partition that includes the first letter. If you have something like
 *  "abaccbdeffed", then you might need to add b. You can use an map like "last['b'] = 5" to help you expand the width of your partition.
 *
 */
public class Day4 {

    public List<Integer> partitionLabels(String s) {
        return PartitionString.partitionString(s);
    }
    //2ms
    class Solution2 {
        public List<Integer> partitionLabels(String s) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0) {
                return res;
            }
            int[] dict = new int[26];
            for (char c : s.toCharArray()) {
                dict[c-'a'] ++;
            }
            int[] curr = new int[26];
            int total = 0;
            int len = 0;
            for (char c : s.toCharArray()) {
                len ++;
                if (curr[c-'a'] == 0) {
                    total ++;
                }
                curr[c-'a']++;
                if (curr[c-'a'] == dict[c-'a']) {
                    total --;
                }
                if (total == 0) {
                    res.add(len);
                    len = 0;
                }
            }
            return res;
        }
    }
    //1ms
    class Solution1 {
        public List<Integer> partitionLabels(String S) {
            int n = S.length();
            List<Integer> res = new ArrayList<>();
            int[] count = new int[26];
            for(int i=0; i<n; i++) count[S.charAt(i)-'a'] =i;
            int start = 0;
            while(start < n){
                int end = getlastIndex(count, S, start);
                res.add(end - start + 1);
                start = end + 1;
            }
            return res;
        }
        public int getlastIndex(int[] count, String s, int start){
            int max = count[s.charAt(start)-'a'];
            int pos = start;
            while(pos < max){
                max = Math.max(max, count[s.charAt(pos)-'a'] );
                pos++;
            }
            return max;
        }
    }
}
