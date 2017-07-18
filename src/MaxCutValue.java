package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 7/11/2017.
 */
public class MaxCutValue {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0) {
            int l = s.nextInt();
            int n = s.nextInt();
            int[] prices = new int[n];
            for(int i = 0 ; i < n; i++) {
                prices[i] = s.nextInt();
            }
            System.out.println(maxCuttedSegs(l,prices));
        }
    }

    private static int maxCuttedSegs(int L, int[] prices) {
        int[] dp = new int[L+1];
        for(int l = 1; l <= L; l++) {
            dp[l] = Integer.MIN_VALUE;
        }

        for(int l = 1; l <= L; l++) {
            for(int i = 1 ; i <= prices.length; i++) {
                if(i <= l) {
                    int res = dp[l-i];
                    if(res != Integer.MIN_VALUE && res + prices[i-1] > dp[l]) {
                        dp[l] = res + prices[i-1];
                    }
                }
            }
        }
        return dp[L];
    }
}
