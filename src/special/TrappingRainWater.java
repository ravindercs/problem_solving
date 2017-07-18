package com.ood.di.special;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ravinderk on 6/17/2017.
 */
/*
Given n non-negative integers in array representing an elevation
map where the width of each bar is 1,
compute how much water it is able to trap after raining.
For example:
Input:


2 0 2
__  __
| | | |
|_|_|_|_
Output:
2
Input:
6
3 0 0 2 0 4
         __
__       | |
| |  __  | |
| |  | | | |
|_|__|_|_|_|
Output:
10

1 1 5 2 7 6 1 4 2 3
Thinking:
1. Need to find the bumps
2.

 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int[] left = new int[n];
            left[0] = a[0];
            for (int i=1; i < n; i++) {
                left[i] = Math.max(left[i - 1], a[i]);
            }

            int[] right = new int[n];
            right[n-1] = a[n-1];
            for (int i = n-2; i>=0;i--){
                right[i] = Math.max(a[i],right[i+1]);
            }

            int w = 0 ;
            for (int i = 0; i < n ; i++) {
                w += Math.min(left[i],right[i]) - a[i];
            }

            System.out.println(w);
        }
    }
}
