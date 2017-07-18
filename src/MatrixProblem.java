package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/16/2017.
 */
/*
Given a boolean matrix mat[M][N] of size M X N,
 modify it such that if a matrix cell mat[i][j] is 1 (or true)
 then make all the cells of ith row and jth column as 1.

 create 2 boolean array of size m and n. //Or use first row and column for this
 Traverse the matrix and populate boolean array now modify the original matrix

 */
public class MatrixProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) {
                for(int j=0; j<n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            if(a[0][0] == 0) {
                for (int i = 1; i < m; i++) {
                    if (a[i][0] == 1) {
                        a[0][0] = 1;
                        break;
                    }
                }
            }


            if(a[0][0] == 0) {
                for (int i = 1; i < n; i++) {
                    if (a[0][i] == 1) {
                        a[0][0] = 1;
                        break;
                    }
                }
            }


            for (int i = 1; i < m; i++) {
                for(int j=1; j<n; j++) {
                    if(a[i][j]==1) {
                        a[i][0] = 1;
                        a[0][j] = 1;
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for(int j=1; j<n; j++) {
                    if(a[i][0]==1 || a[0][j] == 1) {
                        a[i][j] = 1;
                    }
                }
            }

            if(a[0][0] == 1) {
                for (int i = 1; i < m; i++) {
                    a[i][0] = 1;
                }
                for (int i = 1; i < n; i++) {
                    a[0][i] = 1;
                }
            }

            for (int i = 0; i < m; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(a[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
