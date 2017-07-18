package com.ood.di;

/**
 * Created by ravinderk on 6/25/2017.
 */
public class LIS_LDS {
    public static void main(String[] args) {
        int[] a = new int[]{ 7,8,1,2,4,6,3,5,2, 1,8,7};
        System.out.println(getLIS(a,a.length));
    }

    private static int[] getLIS(int[] a, int n) {
        int[] T = new int[n];
        int[] I = new int[n];
        for (int i = 0; i < n; i++) {
            T[i] = 1;
            I[i] = -1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0 ; j < i; j++) {
                if(a[i] > a[j] && T[i] < T[j] + 1) {
                    T[i] = T[j] + 1;
                    I[i] = j;
                }
            }
        }

        printSubSeq(a,I);

        return T;
    }

    private static void printSubSeq(int[] a, int[] I) {
        for (int i = a.length-1; i>=0; i--) {
            printRec(a,I,i);
            System.out.println();
        }
    }

    private static void printRec(int[] a, int[] I, int i) {
        if(i<0)  return;
        printRec(a,I,I[i]);
        System.out.print(a[i]+" ");
    }
}
