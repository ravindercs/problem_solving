package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/18/2017.
 */
/*
Given an array of positive numbers, find the maximum sum of a subsequence
with the constraint that no 2 numbers in the sequence should be adjacent
in the array. So 3 2 7 10 should return 13 (sum of 3 and 10)
or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).

Think:
for an element i, there are two possibilities
consider the current element or consider next.
3 2 7 10 => 3 => max(maxseq(0)+7,maxseq(-1)+2) => max(maxseq(1)+10,maxseq(0)+7)
1 2 3 4 5 => 9
5 4 3 2 1 =>
10 5 6 7 1 12
 */
public class MaxSumWithoutAdjacent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int maxPre = a[0];
            int maxNext = Math.max(a[1],a[0]);
            for(int i = 2; i < n; i++) {
                int m = Math.max(maxPre+a[i], maxNext);
                maxPre = maxNext;
                maxNext = m;
            }

            System.out.println(Math.max(maxNext, maxPre));
        }
    }
}
