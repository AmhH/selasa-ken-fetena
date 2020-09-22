package com.example.leet.nadew;

import java.util.LinkedList;
import java.util.Queue;

/**
 * given an integer n and set of chars s = ['a', 'b', 'c', 'd', 'e', 'f'] and isSmart(s) API returns true if s is
 * smart false otherwise. find the number of smart strings of length l<=n.
 * # create different combination the char length <=n
 * # check and count
 * # length 0 => isSmart
 * # length 1 => a, b, c, d, e, f
 * # length 2 => aa, ab, ac, ad …
 * 		bb, ba, bc, bd …
 * # length 3 => aaa, aab, aac ...
 * 		aba, abb, abc …
 * # create a set to hold the combination
 * # queue empty string
 * # while q not empty
 * # poll from the queue for each char in chars(s) append the char to first element of in q
 * # add to the set and queue the combination if it is <=n
 * # for each element of set check isSmart and count
 *
 * Nadew Gelbete
 */
public class SmartString {

    public static int smartCount(char[] chars, int n){
        int count = 0;
        Queue<String> q = new LinkedList<>();
        q.offer("");
        while(!q.isEmpty()){
            StringBuilder  temp = new StringBuilder(q.poll());
            count += isSmart(temp.toString()) ? 1 : 0;
            for(char c : chars){
                temp.append(c);
                if(temp.length() <= n){
                    String s  = temp.toString();
                    q.offer(s);
                }
                temp.deleteCharAt(temp.length() -1);
            }
        }

        return count;
    }

    public static boolean isSmart(String s){
        return s.length() > 345;
    }
}
