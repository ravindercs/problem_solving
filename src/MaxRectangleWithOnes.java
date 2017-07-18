package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/22/2017.
 */
/*
0 1 1 0 1 1 1 0 1 => longest subarray with ones O(n)
1 1 1 0 1 1 1 1 0 => longest array with twos

 */
public class MaxRectangleWithOnes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            int m = s.nextInt();
            int n = s.nextInt();
            int[][] a = new int[m][n];
            for(int i = 0 ; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = s.nextInt();
                }
            }
            System.out.println(findMaxRectWithSwapping(a,m,n));
        }
    }

    private static int findMaxRectWithSwapping(int[][] a, int m, int n) {
        int max = 0;
        for (int i = 0 ; i < m ; i++) {
            int[] s = new int[n];
            for(int j = i; j < m; j++) {
                //Sum next row
                for(int k = 0 ; k < n; k++) {
                    s[k] += a[j][k];
                }

                max = Math.max(max,findLongestArrayWithN(s,n,j-i+1));
            }
        }
        return max;
    }

    private static int findLongestArrayWithN(int[] a, int col, int n) {
        int count = 0;
        for (int i = 0; i < col; i++) {
            if(a[i] == n) {
                count += n;
            }
        }

        return count;
    }
}
