package com.ood.di;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ravinderk on 6/15/2017.
 */
public class NutsBolts2 {
    public static void main(String[] args) {
        char[] c = new char[]{'!','#','$', '%', '&', '*', '@' ,'^', '~'};
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            char[] nuts = new char[n];
            char[] bolts = new char[n];
            for (int i = 0 ; i < n; i++) {
                nuts[i] = sc.next(".").charAt(0);
            }
            for (int i = 0 ; i < n; i++) {
                bolts[i] = sc.next(".").charAt(0);
            }
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(nuts[i],1);
            }
            for (int i = 0 ; i < c.length; i++) {
                if(map.containsKey(c[i])) {
                    System.out.print(c[i]+" ");
                }
            }
            System.out.println();
            for (int i = 0 ; i < c.length; i++) {
                if(map.containsKey(c[i])) {
                    System.out.print(c[i]+" ");
                }
            }
            System.out.println();
        }
    }
}
