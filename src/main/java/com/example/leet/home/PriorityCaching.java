package com.example.leet.home;

import java.util.*;

/**
 *
 */
public class PriorityCaching {
    public static List<Integer> cacheContents(List<List<Integer>> callLogs){
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Set<Integer>> callLogMap = new HashMap<>();
        Set<Integer> cacheValues = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (List<Integer> item : callLogs){
            int time = item.get(0);
            int id = item.get(1);
            max = Math.max(max, time);
            min = Math.min(min, time);
            Set<Integer> ids = callLogMap.getOrDefault(time, new HashSet<>());
            ids.add(id);
            callLogMap.put(time, ids);
        }

        for(int i = min; i <= max; i++){
            Set<Integer> value = callLogMap.get(i);
            countMap.forEach((k, v) -> {
                if(v > 0 && !value.contains(k)){
                    countMap.put(k, countMap.get(k) - 1);
                }
            });
            for(Integer id : value){
                Integer priority = countMap.get(id);
                if(null != priority){
                    countMap.put(id, priority + 2);
                }else {
                    countMap.put(id, 2);
                }
            }
            countMap.forEach((k, v) -> {
                if(v > 5 && !cacheValues.contains(k)){
                    cacheValues.add(k);
                }
                if(v <= 3 && cacheValues.contains(k)){
                    cacheValues.remove(k);
                }
            });
        }
        return new ArrayList<>(cacheValues);
    }
}
