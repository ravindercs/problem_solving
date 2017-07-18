package com.ood.di;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by ravinderk on 6/24/2017.
 */

/*
Print sorted k elements by frequency
 */
public class PrintFreqSorted {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int k = s.nextInt();
            List<HashSet<Integer>> a = new LinkedList<>();
            int[] c = new int[n];
            for(int i = 0 ; i<n; i++) {
                int e = s.nextInt();
                insert(a, e);
                print(a,k);
            }
            System.out.println();
        }
    }

    private static void print(List<HashSet<Integer>> a, int k) {
        for (int i = a.size()-1 ; i >=0 && k > 0; i--) {
            Integer[] l = new Integer[a.get(i).size()];
            a.get(i).toArray(l);
            Arrays.sort(l);
            for (int j = 0 ; j < l.length && k >0; j++) {
                System.out.print(l[j]+" ");k--;
            }
        }
    }

    private static void insert(List<HashSet<Integer>> a, int e) {
        for (int i = 0 ; i < a.size(); i++) {
            if(a.get(i).contains(e)) {
                a.get(i).remove(e);
                if(i == a.size()-1) {
                    a.add(new HashSet<>());
                }
                a.get(i+1).add(e);
                return;
            }
        }

        if(a.size() == 0) {
            a.add(new HashSet<>());
        }
        a.get(0).add(e);
    }
}
