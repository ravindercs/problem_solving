package com.ood.di;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ravinderk on 7/17/2017.
 */
public class ConnectRopes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0 ; i < n ; i++) {
                a[i] = s.nextInt();
            }

            System.out.println(calculateMinCost(a,n));
        }
    }

    private static int calculateMinCost(int[] a, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < n ; i++) {
            pq.add(a[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            cost += first + second;
            pq.add(first+second);
        }

        return cost;
    }
}
