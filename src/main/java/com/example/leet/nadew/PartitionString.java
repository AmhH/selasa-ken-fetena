package com.example.leet.nadew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so
 * that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 */
public class PartitionString {
    public static List<Integer> partitionString(String str){
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), i);
        }
        int max = -1;
        int prev = 0;
        for (int i = 0; i < str.length(); i++) {
            int lastIndex = map.get(str.charAt(i));
            if(lastIndex > max)
                max = lastIndex;
            if(max==i) {
                list.add(max-prev+1);
                prev = max + 1;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(partitionString("ababcbacadefegdehijhklij"));
    }
}
