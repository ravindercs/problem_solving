package com.ood.di;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by ravinderk on 6/28/2017.
 */
public class SumOfMinMaxOfSubArrayK {
    public static void main(String[] args) {
        findSum(new int[]{2, 5, -1, 7, -3, -1, -2}, 4);
    }

    private static void findSum(int[] a, int k){
        if(a.length >= k) {
            PriorityQueue<Integer> mi = new PriorityQueue<>();
            PriorityQueue<Integer> mx = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < k; i++) {
                mi.add(a[i]);
                mx.add(a[i]);
            }
            int sum = mi.peek() + mx.peek();
            for(int i = k; i < a.length; i++) {
                mi.remove(a[i-k]);
                mx.remove(a[i-k]);
                mi.add(a[i]);
                mx.add(a[i]);
                sum += mi.peek() + mx.peek();
            }
            System.out.println(sum);
        }
    }
}
