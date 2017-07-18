package com.ood.di;

import java.util.Arrays;

/**
 * Created by ravinderk on 6/3/2017.
 */
public class SubsetProblemDP {
    private static boolean isSubset(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        //Sum is odd so not possible
        if((sum & 1) == 1) return false;
        return isSubsetUtil(arr, arr.length, sum/2);
    }

    private static boolean isSubsetUtil(int[] arr, int n, int sum) {
        if(sum == 0) return true;
        if(n == 0) return false;
        //Divide the problem
        //Consider last element
        if(arr[n-1] > sum) {
            return isSubsetUtil(arr, n-1, sum);
        }

        return isSubsetUtil(arr,n-1, sum-arr[n-1]) || isSubsetUtil(arr,n-1, sum);
    }

    public static void main(String[] args) {
        System.out.println(isSubset(new int[] {1,2,11,8}));
    }
    /*
    S(a,i,sum) = S(a,i-1,sum-a[i]) || S(a,i,sum);

     */
}
