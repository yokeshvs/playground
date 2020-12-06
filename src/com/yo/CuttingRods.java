package com.yo;

import java.util.PriorityQueue;

public class CuttingRods {
    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>((a,b) -> a-b);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        while (!integers.isEmpty()) {
            System.out.println(integers.poll());
        }
        //System.out.println(cutProfit(5, new int[]{2, 5, 7, 8}));
    }

    private static int cutProfit(int len, int[] price) {
        int[][] dp = new int[price.length+1][len+1];

        for(int i=1; i<=price.length; i++) {
            for (int j=1; j<=len; j++) {
                if(j >= i) {
                    dp[i][j] = Math.max(dp[i-1][j], price[i-1] + dp[i][j-i]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[price.length][len];
    }
}
