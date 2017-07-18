package com.ood.di;

import java.util.*;

/**
 * Created by ravinderk on 6/25/2017.
 */
public class AllPathFinder {
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        while (t-->0) {
//            int v = s.nextInt();
//            int e = s.nextInt();
//            Map<Integer,List<Integer>> g = new HashMap<>();
//            for (int i = 0 ; i < v; i++) {
//                g.put(i,new LinkedList<>());
//            }
//            for (int i = 0 ; i < e; i++) {
//                g.get(s.nextInt()).add(s.nextInt());
//            }
//
//            int[] count = new int[1];
//            findAllPaths(g,s.nextInt(),s.nextInt(), count);
//        }
//    }

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0) {
            int n = s.nextInt();
            int sum = s.nextInt();
            int[] a = new int[n];
            for(int i = 0 ; i < n; i++) {
                a[i] = s.nextInt();
            }
        }
    }

    private static void findAllPaths(Map<Integer,List<Integer>> g, int s, int d, int[] c) {
        boolean[] v = new boolean[g.size()];
        dfs(g,v,s,d,c);
        System.out.println(c[0]);
    }

    private static void dfs(Map<Integer,List<Integer>> g, boolean[] v, int s, int d, int[] c) {
        if(s == d) {
            c[0]++;
            return;
        }
        v[s] = true;
        g.get(s).forEach( i -> {
                if(!v[i]) {
                    dfs(g,v,i,d,c);
                }
        });
        v[s] = false;
    }
}
