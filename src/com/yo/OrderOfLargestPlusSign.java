package com.yo;

import java.util.Arrays;

public class OrderOfLargestPlusSign {
    public static void main(String[] args) {

    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for(int i=0; i<N; i++)
            Arrays.fill(grid[i], 1);
        for (int[] mine : mines) grid[mine[0]][mine[1]] = 0;

        int res = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    res = expand(grid, i, j, res);
                }
            }
        }
        return res;
    }

    private int expand(int[][] grid, int i, int j, int res) {
        int order = 1;
        while(i-1>=0 && i+1 < grid.length && j-1 >= 0 && j+1 < grid[0].length && grid[i-1][j] == 1 && grid[i-1][j] == grid[i+1][j] && grid[i][j-1] == grid[i][j+1])
            order++;

        return Math.max(res, order);
    }
}
