package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 7/13/2017.
 */
/*
2 2 3 7

 */
public class EqualChocolates {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0 ; i < n ; i++) {
                a[i] = s.nextInt();
            }

            System.out.println(equalize(a,n));
        }
    }

    private static int equalize(int[] a, int n) {
        int steps = 0;
        int diff = 0;
        int max = 0;
        while (true) {
            int[] minmax = getMinMaxIndex(a,n,diff,max);
            diff = a[minmax[1]]-a[minmax[0]];
            max = a[minmax[1]];
            if(diff == 0) {
                break;
            }

            steps += countSteps(diff);
        }

        return steps;
    }

    private static int countSteps(int n) {
        int[] c = {1,2,5};
        int[] d = new int[n+1];
        d[0] = 0;
        d[1] = 1;
        for(int i = 2; i <= n; i++) {
            d[i] = Integer.MAX_VALUE;
            for (int j = 0 ; j < c.length; j++) {
                if(c[j] <= i) {
                    d[i] = Math.min(d[i],d[i-c[j]]+1);
                }
            }
        }

        return d[n];
    }

    private static int[] getMinMaxIndex(int[] a, int n, int diff, int pmax) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE ;
        int[] minmax = {-1,-1};
        for (int i = 0 ; i < n; i++) {
            if(diff != 0 && a[i] != pmax) {
                a[i] += diff;
            }
            if(min > a[i]) {
                min = a[i];
                minmax[0] = i;
            }
            if(max < a[i]) {
                max = a[i];
                minmax[1] = i;
            }
        }

        return minmax;
    }
}
