package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 7/10/2017.
 */
public class CountPath {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int k = s.nextInt();
            int[][] a = new int[n+1][m+1];
            for(int i = 0 ; i < k ; i++) {
                a[s.nextInt()][s.nextInt()] = -1;
            }
            System.out.println(countPath(a,n,m));
        }
    }

    private static long countPath(int[][] a, int n, int m) {
        if(a[1][1] == -1) {
            return 0;
        }
        for(int i = 1; i <= n ; i++) {
            if(a[i][1] == 0) a[i][1] = 1;
            else break;
        }
        for(int i = 2; i <= m ; i++) {
            if(a[1][i] == 0) a[1][i] = 1;
            else break;
        }
        for(int i = 2; i <= n ; i++) {
            for(int j = 2; j <= m ; j++) {
                if(a[i][j-1] > 0) {
                    a[i][j]= a[i][j] + a[i][j-1];
                }
                if(a[i-1][j] > 0) {
                    a[i][j]= a[i-1][j] + a[i][j];
                }
            }
        }
        return a[n][m] % 1000000007;
    }
}
