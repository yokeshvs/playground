package com.yo.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingPattern {
    public static void main(String[] args) {
        System.out.println(trioMinSum(new int[]{1,2,2,3,4,5}, new int[]{2,4,5,5,5,6})); //3
        System.out.println(trioMinSum(new int[]{1,1,2,2,3,4}, new int[]{2,3,3,4,4,5})); //2
    }

    private static int trioMinSum(int[] from, int[] to) {
        int n = from.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<n; i++) {
            graph.get(from[i]).add(to[i]);
            graph.get(to[i]).add(from[i]);
        }

        int sum = Integer.MAX_VALUE;
        for(int one : graph.keySet()) {
            for(int two : graph.get(one)) {
                for(int three : graph.get(two)) {
                    if (graph.get(three).contains(one)) {
                        sum = Math.min(sum, graph.get(one).size() + graph.get(two).size() + graph.get(three).size() - 6);
                    }
                }
            }
        }

        System.out.println(graph);
        return sum;
    }
}
