package com.ood.di;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/24/2017.
 */
public class SumSubArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for(int i =0 ; i < n; i++) {
                a[i] = s.nextInt();
            }
            BigInteger sum = new BigInteger(s.next());
            findSubarrayWithSum(sum,a,n);
        }
    }

    private static void findSubarrayWithSum(BigInteger sum,int[] a, int n) {

        BigInteger[] sa = new BigInteger[n];
        sa[0] = BigInteger.valueOf(a[0]);
        for(int i = 1 ; i < n; i++) {
            sa[i] = sa[i-1].add(BigInteger.valueOf(a[i]));
        }
        //1 2 3 4
        //1 3 6 10
        for (int i = 0; i < n; i++) {
            BigInteger p = BigInteger.valueOf(0);
            if(i>0) p = sa[i-1];
            for(int j = i; j < n; j++) {
                BigInteger cs = sa[j].subtract(p);
                if(cs.equals(sum)) {
                    System.out.println(i+" "+j);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
