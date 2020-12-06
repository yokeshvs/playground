package com.yo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");
        System.out.print("Please enter the size of grid:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        char[][] grid = new char[n][n];
        printGrid(grid);
        boolean gameOver = false;

        while (!gameOver) {
            System.out.print("Enter row:");
            int row = scanner.nextInt();
            System.out.print("Enter col:");
            int col = scanner.nextInt();

        }
    }

    private static void printGrid(char[][] grid) {
        for (char[] chars : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(" |" + chars[j] + "| ");
            }
            System.out.println();
        }
    }
}
