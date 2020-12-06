package com.yo.amazon;

import java.util.HashMap;
import java.util.Map;

public class FindHighestProfit {
    public static void main(String[] args) {
        System.out.println(findHighestProfit(new Long[]{5L, 3L}, 6));
    }

    private static long findHighestProfit(Long[] inventory, int order) {
        Map<Long, Integer> map = new HashMap<>();
        long curMax = Integer.MIN_VALUE;
        for (Long aLong : inventory) {
            map.put(aLong, map.getOrDefault(aLong, 0) + 1);
            curMax = Math.max(curMax, aLong);
        }
        long res = 0L;
        while (order > 0 && map.size() != 0) {
            int items = Math.min(order, map.get(curMax));
            res += items * curMax;
            map.remove(curMax);
            map.put(curMax-1, map.getOrDefault(curMax-1, 0) + items);
            curMax--;
            order = order - items;
        }
        return res;
    }
}
