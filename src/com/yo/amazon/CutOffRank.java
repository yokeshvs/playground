package com.yo.amazon;

public class CutOffRank {
    public static void main(String[] args) {
        System.out.println(cutOffRank(4, 5, new int[]{2,2,3,4,5}));
        System.out.println(cutOffRank(3, 4, new int[]{100,50,50,25}));
    }

    public static int cutOffRank(int cutOffRank, int num, int[] scores) {
        int[] frequencies = new int[100 + 1];
        for (int score : scores) {
            frequencies[score]++;
        }

        int ans = 0;
        int currentRank = 1;
        for (int i = 100; i >= 0 && currentRank <= cutOffRank; i--) {
            if (frequencies[i] == 0) continue;

            ans += frequencies[i];
            currentRank += frequencies[i];
        }
        return ans;
    }
}