package com.yo.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AircraftRouteOptimization {
    public static void main(String[] args) {
        ArrayList<Pair> forward = new ArrayList<>();
        ArrayList<Pair> reverse = new ArrayList<>();

        forward.add(new Pair(1, 1000));
        forward.add(new Pair(2, 2000));
        forward.add(new Pair(3, 4000));
        forward.add(new Pair(4, 5000));
        forward.add(new Pair(5, 6000));
        forward.add(new Pair(6, 7000));

        reverse.add(new Pair(1, 1000));
        reverse.add(new Pair(2, 2000));
        reverse.add(new Pair(3, 4000));
        reverse.add(new Pair(4, 5000));
        reverse.add(new Pair(5, 6000));
        reverse.add(new Pair(6, 7000));

        List<int[]> res = findOptimizedRoutes(forward, reverse, 20000);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
        }

    }

    private static List<int[]> findOptimizedRoutes(ArrayList<Pair> forward, ArrayList<Pair> reverse, int maxTravelDist) {
        int max = Integer.MIN_VALUE;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0; i< forward.size(); i++) {
            for(int j=0; j<reverse.size(); j++) {
                int sum = forward.get(i).distance + reverse.get(j).distance;
                if (sum <= maxTravelDist && sum >= max) {
                    max = sum;
                    List<int[]> toAdd = map.getOrDefault(sum, new ArrayList<int[]>());
                    toAdd.add(new int[]{forward.get(i).id, reverse.get(j).id});
                    map.put(sum, toAdd);
                }
            }
        }
        return map.get(max);
    }

    static class Pair {
        int id;
        int distance;
        Pair(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }
    }
}
