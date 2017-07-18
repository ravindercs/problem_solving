package com.ood.di;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/19/2017.
 */
/*
3 4 7 1 2 9 8

1 2 4 3 7 8 9
 */
public class SumEqual2Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0 ; i < n ; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(isSumOfSumm(a,n));
        }
    }

    private static int isSumOfSumm(int[] a, int n) {
        Arrays.sort(a);
        for (int i = 0 ; i < n-3 ; i++) {
            for (int j = i+1; j < n-2; j++) {
                for (int k = j+1; k < n-1; k++) {
                    for (int l = k+1; l < n; l++) {
                        if(a[i]+a[l] == a[j]+a[k]) {
                            return 1;
                        }
                    }
                }
            }
        }

        return 0;
    }
}
