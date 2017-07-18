package com.ood.di;

import java.math.BigInteger;

/**
 * Created by ravinderk on 7/11/2017.
 */
public class MinimumSteps {
    public static void main(String[] args) {
//        int[]  a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
//        int[]  a = {1, 3, 6, 1, 0, 9};
//        System.out.println(minSteps(a, a.length));
        System.out.println(waysToScore(14));
        System.out.println(waysToScore(20));
    }

    private static int waysToScore(int n) {
        if(n == 0) return 0;
        //3,4,10
        int[] dp = new int[n+1];
        dp[0] = 1;
        int[] chances = {3,5,10};
        for(int j = 0 ; j < chances.length; j++) {
            for (int i = chances[j]; i <= n; i++) {
                dp[i] += dp[i - chances[j]];
            }
        }

        return dp[n];
    }
    /*
    20 =>
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
    1 0 0 1 0 0 1 0 0 1 0  0  1  0  0
    1 0 0 1 0 1 1 0 1 1 2  1  1  1  1
    1 0 0 1 0 1 1 0 0 1 2  0  0  1  1
     */

    private static int minSteps(int[] a, int n){
        if(a[0] == 0) return 0;

        int[] dp = new int[n+1];
        for (int i = 0 ; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i ; j <= n && j < i+a[i-1]; j++) {
                dp[j] = Math.min(dp[j],dp[i-1]+1);
            }
        }
        return dp[n];
    }
}
