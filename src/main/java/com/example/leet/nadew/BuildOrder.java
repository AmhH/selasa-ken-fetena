package com.example.leet.nadew;

import java.util.*;

/**
 * Build order: You are given a list of projects and a list of dependencies (which is a list of pairs of projects,
 * where the second project is dependent on the first projects). All of a project’s dependencies must be built before
 * the project is. Find a build order that will allow the projects to be built. If there is no valid build order,
 * return an error.
 * Example: Input
 *           	Projects: a, b, c, d, e, f
 *           	Dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 * Output: f, e, a, b, d, c
 * Input
 *           	Projects: a, b, c, d, e, f, g
 *           	Dependencies: (a, e), (f, c), (b, a), (d, g), (f, b), (b, e), (c, a), (f, a),
 * Output: f, d, c, b, g, a, e
 *
 */
public class BuildOrder {

    public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for(String project : projects){
            inDegree.put(project, 0);
        }

        for(String[] dependency : dependencies){
            List<String> list = graph.getOrDefault(dependency[0], new ArrayList<>());
            list.add(dependency[1]);
            graph.put(dependency[0], list);
            inDegree.put(dependency[1], inDegree.getOrDefault(dependency[1], 0)+1);
        }

        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> inEntry : inDegree.entrySet()) {
            if(inEntry.getValue() == 0)
                queue.offer(inEntry.getKey());
        }

        while(!queue.isEmpty()){
            String node = queue.poll();
            result.add(node);
            for(String child : graph.getOrDefault(node, new ArrayList<>())){
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child).equals(0))
                    queue.add(child);
            }
        }

        if(result.size() == projects.length)
            return result.toArray(new String[projects.length]);


        return null;
    }

    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
        String[] buildOrder = buildOrderWrapper(projects, dependencies);
        if (buildOrder == null)  {
            System.out.println("Circular Dependency.");
        } else {
            System.out.println(Arrays.toString(buildOrder));
        }
    }
}
