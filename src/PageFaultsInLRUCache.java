package com.ood.di;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/24/2017.
 */
public class PageFaultsInLRUCache {
    private LinkedHashSet<Integer> cache = null;
    private int capacity;
    private int faults;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i<n; i++) {
                a[i] = s.nextInt();
            }
            int c = s.nextInt();
            PageFaultsInLRUCache cache = new PageFaultsInLRUCache(c);
            for (int i = 0; i<n; i++) {
                cache.get(a[i]);
            }
            System.out.println(cache.faults);
        }
    }

    /*Inititalize an LRU cache with size N */
    public PageFaultsInLRUCache(int N) {
        cache = new LinkedHashSet<>(N);
        capacity = N;
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public boolean get(int x) {
        if(cache.contains(x)) {
            cache.remove(x);
            cache.add(x);
        } else {
            faults++;
            set(x);
        }
        return cache.contains(x);
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x) {
        if(!cache.contains(x)) {
            if(cache.size() == capacity) {
                int key = cache.iterator().next();
                cache.remove(key);
            }
        } else {
            cache.remove(x);
        }
        cache.add(x);
    }
}
