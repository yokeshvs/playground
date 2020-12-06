package com.yo;

public class LongestRepeatingSubstring {
    public static void main(String[] args) {
        System.out.println(lrs("banana"));
    }

    private static String lrs(String a) {
        int[][] dp = new int[a.length()+1][a.length()+1];
        int max = 0; int[] maxIndex = new int[2];
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < a.length() + 1; j++) {
                if(a.charAt(i-1) == a.charAt(j-1) && i != j) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                    maxIndex[0] = i;
                    maxIndex[1] = j;
                }
            }
        }
        int i = maxIndex[0], j = maxIndex[1];
        StringBuilder sb = new StringBuilder();
        while(dp[i][j] != 0) {
            sb.append(a.charAt(i-1));
            i--;
            j--;
        }
        System.out.println(max);
        return sb.reverse().toString();
    }
}
