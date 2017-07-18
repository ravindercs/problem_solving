package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/25/2017.
 */
public class MinSquaresOfRect {
    static long[][] dp = new long[600][600];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        while(t-->0) {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println(minSquares(a,b));
        }
    }

    private static long minSquares(int a, int b) {
        if (a == b) return 1;

        if(dp[a][b] != 0) return dp[a][b];

        long min = a*b;
        for (int i = 1; i <= a / 2; i++) {
            long t = minSquares(i, b) + minSquares(a-i,b);
            min = Math.min(t, min);
        }

        for (int i = 1; i <= b / 2; i++) {
            long t = minSquares(a, i) + minSquares(a,b-i);
            min = Math.min(t, min);
        }

        dp[a][b] = min;
        return min;
    }
}
