package com.yo.amazon;

import java.util.*;

public class ItemAssociation {
    public static void main(String[] args) {
        List<Pair> pairs = new ArrayList<>();


        pairs.add(new Pair("item5", "item6"));
        pairs.add(new Pair("item7", "item6"));
        pairs.add(new Pair("item6", "item8"));

        pairs.add(new Pair("item1", "item2"));
        pairs.add(new Pair("item3", "item2"));
        pairs.add(new Pair("item4", "item3"));

        System.out.println(largestItemAssociation(pairs));
    }

    public static List<String> largestItemAssociation(List<Pair> itemAssociation) {
        Map<String, List<String>> graph = new HashMap<>();
        for(Pair pair : itemAssociation) {
            if(!graph.containsKey(pair.first)) {
                graph.put(pair.first, new ArrayList<>());
            }
            graph.get(pair.first).add(pair.second);
            if(!graph.containsKey(pair.second)) {
                graph.put(pair.second, new ArrayList<>());
            }
            graph.get(pair.second).add(pair.first);
        }

        Set<String> visited = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (String entry : graph.keySet()) {
            List<String> cur = new ArrayList<>();
            dfs(graph, visited, entry, cur);
            if (res.size() < cur.size())
                res = cur;
        }
        Collections.sort(res);
        return res;
    }

    private static void dfs(Map<String, List<String>> graph, Set<String> visited, String entry, List<String> list) {
        if (visited.contains(entry)) return;
        list.add(entry);
        visited.add(entry);
        for(String next : graph.get(entry)) {
            if (!visited.contains(next)) dfs(graph, visited, next, list);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
