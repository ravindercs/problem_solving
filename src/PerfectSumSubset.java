package com.ood.di;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2017.
 */
public class PerfectSumSubset {
    //All subsets vs all sub array
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0 ; i < n; i++) {
                a[i] = s.nextInt();
            }
            int sum = s.nextInt();
            isSubsetSum(a,n,sum);
        }
    }

    private static void isSubsetSum(int[] a, int n, int s) {
        boolean[][] dp = new boolean[n+1][s+1];
        for (int i = 0 ; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1 ; i <= s; i++) {
            dp[0][i] = false;
        }

        for (int i = 1 ; i <= n; i++) {
            for (int j = 1; j <= s ; j++) {
                if(a[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-a[i-1]];
                }
            }
        }

        List<Integer> count = new LinkedList<>();
        count.add(0);
        countSolRec(a,dp, n, s, count);
        System.out.println(count.get(0));
    }

    private static void countSolRec(int[] a, boolean[][] dp, int i, int s, List<Integer> count) {
        if(i == 1 && s != 0 && dp[1][s]) {
            count.set(0,count.get(0)+1); return;
        }

        if(i == 0 && s == 0) {
            count.set(0,count.get(0)+1); return;
        }

        if(dp[i-1][s]) {
            countSolRec(a,dp,i-1,s,count);
        }

        if(s >= a[i-1] && dp[i-1][s-a[i-1]]) {
            countSolRec(a,dp, i-1, s-a[i-1], count);
        }
    }
}
