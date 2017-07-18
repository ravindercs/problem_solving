package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/19/2017.
 */
/*
Given a 2D array, find the maximum sum subarray in it. For example,
in the following 2D array, the maximum sum subarray is highlighted
with blue rectangle and sum of this subarray is 29.
 */
public class MaxSum2DArray {
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

            System.out.println(maxSumCalculator(a,m,n));
        }
    }

    private static int maxSumCalculator(int[][] a, int m, int n) {
        int g_max = Integer.MIN_VALUE;

        for (int i = 0 ; i < m ; i++) {
            int[] s = new int[n];
            for (int j = i; j < m; j++) {
                sumArrays(s, a[j]);
                int cur_max = kadane(s);
                g_max = Math.max(g_max, cur_max);
            }
        }

        return g_max;
    }

    private static void sumArrays(int[] s, int[] a) {
        for (int i = 0 ; i < a.length; i++) {
            s[i] += a[i];
        }
    }

    private static int kadane(int[] a){
        int g_max = a[0];
        int cur_max = a[0];
        for (int i = 1; i < a.length ; i++) {
            cur_max = Math.max(a[i],cur_max + a[i]);
            g_max = Math.max(cur_max,g_max);
        }

        return g_max;
    }
}
