package com.example.leet.nadew;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:
 * 1.  	Only one letter can be changed at a time.
 * 2.  	Each transformed word must exist in the word list.
 * Note:
 * •	Return 0 if there is no such transformation sequence.
 * •	All words have the same length.
 * •	All words contain only lowercase alphabetic characters.
 * •	You may assume no duplicates in the word list.
 * •	You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 * https://leetcode.com/problems/word-ladder/solution/
 */
public class ShortestTransformation {



    public int shortestTransformation(String beginWord, String endWord, List<String> wordList){
        if(beginWord.equals(endWord))
            return 0;
        if(!wordList.contains(endWord))
            return 0;

        Map<String, List<String>> graph = getPossibleWordCombo(wordList);

        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.offer(beginWord);
        q.offer(null);
        int minLength = 0;

        while(!q.isEmpty()){
            String node = q.poll();
            if (node == null) {
                minLength++;
                if (!q.isEmpty()) q.add(null);
                continue;
            }
            if(node.equals(endWord)){
                return minLength + 1;
            }

            seen.add(node);
            for(int i = 0; i < node.length(); i++){
                String temp = node.substring(0, i) + '#' + node.substring(i + 1);
                List<String> list = graph.get(temp);
                if(list != null){
                    for(String n : list){
                        if(!seen.contains(n)){
                            q.offer(n);
                        }
                    }
                }
            }
        }

        return 0;
    }

    private Map<String, List<String>> getPossibleWordCombo(List<String> list){
        Map<String, List<String>> map = new HashMap<>();
        for(int j = 0; j < list.size(); j++){
            String current = list.get(j);
            for(int i = 0; i < current.length(); i++){
                String temp = current.substring(0, i) + '#' + current.substring(i + 1);
                List<String> l = map.getOrDefault(temp, new ArrayList<>());
                l.add(current);
                map.put(temp, l);
            }

        }

        return map;
    }


    public static void main(String[] args) {
        System.out.println(new ShortestTransformation().shortestTransformation("hit", "cog",
                Arrays.asList("hot","dot", "dog","lot","log","cog")));
        System.out.println(new ShortestTransformation().shortestTransformation("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log")));

        System.out.println(new ShortestTransformation().shortestTransformation("lost", "miss",
                Arrays.asList("most","mist","miss","lost","fist","fish")));
    }
}
