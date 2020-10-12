package com.example.leet.october.week2;

import java.util.Stack;

/**
 * Remove Duplicate Letters
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible results.
 *
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 *    Hide Hint #1
 * Greedily try to add one missing character. How to check if adding some character will not cause problems ? Use
 * bit-masks to check whether you will be able to complete the sub-sequence if you add the character at some index i.
 */
public class Day11 {
    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++)
            lastIndex[s.charAt(i) - 'a'] = i; // track the lastIndex of character presence
        boolean[] seen = new boolean[26]; // keep track seen
        Stack<Integer> st = new Stack();
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if(seen[c]) continue; // if seen continue as we need to pick one char only
            while(!st.isEmpty() && st.peek() > c && i < lastIndex[st.peek()])
                seen[st.pop()] = false; // pop out and mark unseen
            st.push(c); // add into stack
            seen[c] = true; // mark seen
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
            sb.append((char)(st.pop() + 'a'));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));//abc
        System.out.println(removeDuplicateLetters1("cbacdcbc"));//acdb
    }

    public static String removeDuplicateLetters1(String s) {

        int [] last=new int[26];
        for(int i=0;i<s.length();i++)last[s.charAt(i)-'a']=i;

        char [] ans=new char[26];
        ans[0]=s.charAt(0);
        boolean [] used=new boolean[26];
        used[ans[0]-'a']=true;

        for(int i=1,j=1;i<s.length();i++){
            char c=s.charAt(i);
            if(used[c-'a'])continue;
            while(j>0 && ans[j-1]>c){
                if(last[ans[j-1]-'a']>i){
                    used[ans[j-1]-'a']=false;
                    j--;
                }
                else{
                    break;
                }
            }
            ans[j++]=c;
            used[c-'a']=true;
        }

        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<26;i++){
            char c=ans[i];
            if(c>='a' && c<='z')sb.append(c);
        }
        return sb.toString();
    }
}
