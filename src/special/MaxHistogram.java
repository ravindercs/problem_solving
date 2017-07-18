package com.ood.di.special;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ravinderk on 6/16/2017.
 */
/*
Find the largest rectangular area possible in a given histogram where
the largest rectangle can be made of a number of contiguous bars.
 For simplicity, assume that all bars have same width and the width is 1 unit.

6 2 5 4 5 1 6


Observations:
1. Min value * length of arr = Area
2.
 */
public class MaxHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            System.out.println(findMaxHist(a, n));
            System.out.println(findMaxHistWithStack(a, n));
        }
    }

    private static int findMaxHist(int[] a, int n) {
        int[] h = new int[n];
        for (int i = 0; i <n; i++) {
            int min = i-1;
            while (min>=0 && a[min] >= a[i]){
                min--;
            }
            int max = i+1;
            while (max < n && a[max] >= a[i]){
                max++;
            }

            h[i] = (max-min-1)*a[i];
        }

        int maxh = h[0];
        for (int i=0; i<n;i++) {
            if(maxh < h[i]) {
                maxh = h[i];
            }
        }
        return maxh  ;
    }

    private static int findMaxHistWithStack(int[] a, int n) {
        Stack<Integer> indexSt = new Stack<>();
        int i =0;
        int max = 0;
        while (i<n){
            if(indexSt.isEmpty() || a[indexSt.peek()] <= a[i]) {
                indexSt.push(i++);
            } else {
                int tp = indexSt.pop();
                int ar_tp = a[tp]*(indexSt.isEmpty() ? i : i-indexSt.peek()-1);
                if(max < ar_tp) {
                    max = ar_tp;
                }
            }
        }

        while (!indexSt.isEmpty()) {
            int tp = indexSt.pop();
            int ar_tp = a[tp]*(indexSt.isEmpty() ? i : i-indexSt.peek()-1);
            if(max < ar_tp) {
                max = ar_tp;
            }
        }

        return max  ;
    }
}
