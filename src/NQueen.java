package com.ood.di;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/20/2017.
 */
/*
The n-queens puzzle is the problem of placing n queens on an
 n×n chessboard such that no two queens attack each other.
  Given an integer n, print all distinct solutions to the n-queens puzzle.
   Each solution contains distinct board configurations of the n-queens’
    placement, where the solutions are a permutation of [1,2,3..n] in increasing order,
     here the number in the ith place denotes that the ith-column queen is placed in the row with that number.
For eg below figure represents a chessboard [3 1 4 2].
 */
public class NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            solve(sc.nextInt());
        }
    }

    private static void solve(int n) {
        int[][] b = new int[n][n];
        if(solve(b,0,n)) {
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static boolean solve(int[][] b, int col, int n) {
        if( col >= n) return true;

        boolean solved = false;
        for (int i = 0 ; i < n; i++) {
            if(isValid(b, i, col,n)) {
                b[i][col] = 1;
                if(solve(b,col+1,n)) {
                    printArr(b,n);
                    solved = true;
                }
                b[i][col] = 0;
            }
        }

        return solved;
    }


    private static boolean isValid(int[][] b, int i, int j, int n) {
        for(int k = 0 ; k < n ; k++) {
            if(b[i][k] == 1) return false;
        }

        for(int k = 0 ; k < n ; k++) {
            if(b[k][j] == 1) return false;
        }

        for (int k = i-1, l = j-1; k>=0 && l >=0 ; k--,l--) {
            if(b[k][l] == 1) return false;
        }

        for (int k = i+1, l = j+1; k < n && l < n ; k++,l++) {
            if(b[k][l] == 1) return false;
        }

        for (int k = i-1, l = j+1; k>=0 && l < n ; k--,l++) {
            if(b[k][l] == 1) return false;
        }

        for (int k = i+1, l = j-1; k < n && l >= 0 ; k++,l--) {
            if(b[k][l] == 1) return false;
        }

        return true;
    }

    private static void printArr(int[][] b, int n) {
        System.out.print("[");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(b[j][i] == 1) {
                    System.out.print(j + 1+ " ");
                    break;
                }
            }
        }
        System.out.print("] ");
    }
}
