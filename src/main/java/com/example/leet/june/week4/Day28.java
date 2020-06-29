package com.example.leet.june.week4;

import java.util.*;

/**
 * Reconstruct Itinerary
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the
 * itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
 * read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */
public class Day28 {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjacent = new HashMap<>();
        for (List<String> flight : tickets){
            adjacent.putIfAbsent(flight.get(0), new PriorityQueue<>());
            adjacent.get(flight.get(0)).offer(flight.get(1));
        }

        LinkedList<String> result = new LinkedList<>();
        dfs(adjacent, result, "JFK");

        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> adjacent, LinkedList<String> result, String airPort) {
        PriorityQueue<String> path = adjacent.get(airPort);

        while (path != null && !path.isEmpty()){
            String str = path.poll();
            dfs(adjacent, result, str);
        }

        result.addFirst(airPort);
    }

    public static void main(String[] args) {
        System.out.println(new Day28().findItinerary(Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"))));

        System.out.println(new Day28().findItinerary(Arrays.asList(Arrays.asList("JFK","SFO"),Arrays.asList("JFK", "ATL")
                ,Arrays.asList("SFO","ATL"),Arrays.asList("ATL", "JFK"),Arrays.asList("ATL","SFO"))));
    }

}
