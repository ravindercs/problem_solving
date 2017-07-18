package com.ood.di;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/18/2017.
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache = null;
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
            LRUCache cache = new LRUCache(c);
            for (int i = 0; i<n; i++) {
                cache.get(a[i]);
            }
            System.out.println(cache.faults);
        }
    }

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        cache = new LinkedHashMap<>(N);
        capacity = N;
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        Integer v = cache.get(x);
        if(v != null) {
            cache.remove(x);
            cache.put(x,v);
        } else {
            faults++;
        }
        return v == null ? -1 : v;
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        Integer v = cache.get(x);
        if(v == null) {
            if(cache.size() == capacity) {
                int key = cache.keySet().iterator().next();
                cache.remove(key);
            }
        } else {
            cache.remove(x);
        }
        cache.put(x, y);
    }
}
