package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 7/14/2017.
 */
public class Kanpsack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0) {
            int N = s.nextInt();
            int W = s.nextInt();
            int[] w = new int[N];
            int[] v = new int[N];
            for (int i = 0 ; i < N ; i++) {
                v[i] = s.nextInt();
            }
            for (int i = 0 ; i < N ; i++) {
                w[i] = s.nextInt();
            }

            System.out.println(maximizeValue(w,v,N,W));
        }
    }

    private static int maximizeValue(int[] w, int[] v, int n, int W) {
        int[][] d = new int[n+1][W+1];

        //W is zero then value is also zero
        //Zero items have value zero

        for (int i = 0 ; i <= n ; i++) {
            for (int j = 0;  j <= W ; j++) {
                if (i == 0 || j == 0) {
                    d[i][j] = 0;
                } else if (w[i - 1] <= j) {//Include
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - w[i - 1]] + v[i - 1]);
                } else {    //Exclude
                    d[i][j] = d[i - 1][j];
                }
            }
        }

        return d[n][W];
    }
}
