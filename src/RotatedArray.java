package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 7/15/2017.
 */
public class RotatedArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0 ; i < n ; i++) {
                a[i] = s.nextInt();
            }
//            int k = s.nextInt();

//            System.out.println(search(a,n,k));
            sortArray(a,n);
        }
    }

    private static void sortArray(int[] a, int n) {

        int low = 0;
        int mid = low;
        int high = n-1;

        while (mid <= high) {
            if(a[mid] == 0) {
                a[mid++] = a[low];
                a[low++] = 0;
            } else if(a[mid] == 2) {
                a[mid] = a[high];
                a[high--] = 2;
            } else {
                mid++;
            }
        }

        for (int i = 0 ; i < n ; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static int search(int[] a, int n, int k) {
        return bsearch(a,0,n-1,k);
    }

    private static int bsearch(int[] a, int l, int r, int k) {
        if(r < l) return -1;
        int m = l + (r-l)/2;

        if(a[m] == k) return m;

        if(a[l] < a[m]) {
            if (a[l] <= k && a[m] >= k) {
                return bsearch(a,l,m-1,k);
            }

            return bsearch(a,m+1,r,k);
        }

        if(a[m] <= k && a[r] >= k) {
            return bsearch(a,m+1,r,k);
        }

        return bsearch(a,l,m-1,k);
    }
}
