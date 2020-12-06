package com.yo.amazon;

import java.util.PriorityQueue;

public class FillTheTruck {
    public static void main(String[] args) {
        System.out.println(fillTheTruck(3, new int[]{1,2,3}, 3, new int[]{3,2,1}, 3));
    }

    private static int fillTheTruck(int n, int[] boxes, int unitSize, int[] unitsPerBox, int truckSize) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < boxes[i]; j++) {
                queue.offer(unitsPerBox[i]);
            }
        }

        while (queue.size() > truckSize) queue.remove();
        int res = 0;
        while (!queue.isEmpty()) res += queue.remove();

        return res;
    }
}
