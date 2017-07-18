package com.ood.di;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/3/2017.
 */
public class EquilibriumIndex {
    //Indexes: [0, 1,2,3, 4,5,6]
    //Arrays:  [-7,1,5,2,-4,3,0]
    //Calculate sum [0,i-1] and calculate sum [i+1,n] if equal then eq index.
    //Remember sum fsum where fs[i] is sum [0,i]
    //Remember sum bsum where bs[i] is sum [i,n]
    //if fs[i-1] == bs[i+1] then true
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++) {
                arr[i]=sc.nextInt();
            }
            System.out.println(getEqIndexOptimized(arr));
        }
    }

    //Arrays:  [-7,1,5,2,-4,3,0]
    //fs = 0, bs = 0;
    //i = 0 , arr[0] = -7, bs => 7 bs != fs, fs => -7; list={}
    //i = 1 , arr[1] = 1, bs => 6 bs != fs, fs => -6; list={}
    //i = 2 , arr[2] = 5, bs => 1 bs != fs, fs => -1; list={}
    //i = 3 , arr[3] = 2, bs => -1 bs == fs, fs => 1; list={3}
    //i = 4 , arr[4] = -4, bs => 3 bs != fs, fs => -3; list={3}
    //i = 5 , arr[5] = 3, bs => 0 bs != fs, fs => 0; list={3}
    //i = 6 , arr[6] = 0, bs => 0 bs != fs, fs => 1; list={3}

    private static int getEqIndexOptimized(int[] arr) {
        int fs = 0;
        int bs = Arrays.stream(arr).sum();

        int eq = -1;
        for (int i = 0; i < arr.length;i++) {
            bs = bs - arr[i];
            if(fs == bs) {
                eq = i+1;
                break;
            }
            fs += arr[i];
        }

        return eq;
    }
}
