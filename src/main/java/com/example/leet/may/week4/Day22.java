package com.example.leet.may.week4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Sort Characters By Frequency
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class Day22 {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue =
                new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            priorityQueue.offer(entry);
        }

        StringBuilder builder = new StringBuilder();

        while (priorityQueue.size() > 0){
            Map.Entry<Character, Integer> entry = priorityQueue.poll();
            for(int i = 0; i < entry.getValue(); i++){
                builder.append(entry.getKey());
            }

        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));

    }

    public String frequencySort1(String s) {
        // a bucket here gathers all the chars with the same frequency.
        List<Character>[] buckets = new List[s.length() + 1];
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) map.merge(c, 1, Integer::sum);

        map.forEach((ch, freq) -> {
            if(buckets[freq] == null) buckets[freq] = new ArrayList<>();
            for(int i=0 ; i<freq ; ++i) buckets[freq].add(ch);
        });

        return new StringBuilder(Arrays.stream(buckets)
                .filter(Objects::nonNull) // exclode the null (empty) buckets
                .flatMap(List::stream) // Stream<List<Character>> to Stream<Character>
                .map(String::valueOf) // chars to strings
                .collect(Collectors.joining())) // join the strings together
                .reverse() // as we want the more frequent first
                .toString();
    }

    public String frequencySort2(String s) {
        int[] arr = new int[256];
        for(char c : s.toCharArray()) {
            arr[c]++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> {
            return arr[b] - arr[a];
        });
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                pq.add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char c = pq.poll();
            for(int i = 0; i < arr[c]; i++) {
                sb.append(c);
            }
        }

        return sb.toString();

    }
}
