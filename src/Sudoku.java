package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/12/2017.
 */
public class Sudoku {
    public static void main(String[] args) {
        int[][] sudoku = new int[9][9];

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = scanner.nextInt();
                }
            }

            solve(sudoku);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void solve(int[][] sudoku) {
        solve(sudoku, 0, 0);
    }

    private static boolean solve(int[][] cells, int i, int j) {
        if (i == 9) {
            i = 0;
            if (++j == 9)
                return true;
        }
        if (cells[i][j] != 0)  // skip filled cells
            return solve(cells,i+1,j);

        for (int val = 1; val <= 9; ++val) {
            if (isValid(cells,i,j,val)) {
                cells[i][j] = val;
                if (solve(cells,i+1,j))
                    return true;
            }
        }
        cells[i][j] = 0; // reset on backtrack
        return false;
    }

    private static boolean isValid(int[][] sudoku, int i, int j, int k) {
        //Check row
        for(int l = 0 ; l < 9 ; l++) {
            if(l != j && sudoku[i][l] == k) {
                return false;
            }
        }

        //Check column
        for(int l = 0 ; l < 9 ; l++) {
            if(l != i && sudoku[l][j] == k) {
                return false;
            }
        }

        //Check containing square
        int si = (i/3)*3;
        int sj = (j/3)*3;
        for(int l = si; l < si+3 ; l++) {
            for(int m = sj; m < sj+3; m++) {
                if(l != i && m != j && sudoku[l][m] == k) {
                    return false;
                }
            }
        }

        return true;
    }
}
