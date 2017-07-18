package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 7/12/2017.
 */
public class Candies {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++) {
            a[i] = s.nextInt();
        }

        System.out.println(totalCandies(a,n));
    }

    private static long totalCandies(int[] a, int n) {
        int[] c = new int[n];
        for(int i = 0 ; i < n; i++) {
            c[i] = 1;
        }

        for(int i = 1 ; i < n; i++) {
            if(a[i] > a[i-1] && c[i] <= c[i-1]) {
                c[i] = c[i-1]+1;
            }
        }

        for(int i = n-2 ; i >= 0; i--) {
            if(a[i] > a[i+1] && c[i] <= c[i+1]) {
                c[i] = c[i+1]+1;
            }
        }

        long total = 0;
        for(int i = 0 ; i < n; i++) {
            total+=c[i];
        }

        return total;
    }
}
