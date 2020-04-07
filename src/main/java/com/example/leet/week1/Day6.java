package com.example.leet.week1;

import java.util.*;

/**
 *  Group Anagrams
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class Day6 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList();

        Map<String, List> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String,ArrayList>H = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char x[] = strs[i].toCharArray();
            Arrays.sort(x);
            String a = new String(x);
            if(H.containsKey(a)){
                ArrayList<String>B = H.get(a);
                B.add(strs[i]);
                H.remove(a);
                H.put(a,B);
            }
            else{
                ArrayList<String>B = new ArrayList<>();
                B.add(strs[i]);
                H.put(a,B);
            }
        }
        List<List<String>>A = new LinkedList<>();
        for(String s: H.keySet()){
            List<String>B = H.get(s);
            A.add(B);
        }
        return A;
    }
}
