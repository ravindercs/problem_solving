package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/16/2017.
 */
public class SubArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] a = new int[n];
            for (int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }

            int start = 0;
            int end = 0;
            int sum = 0;
            int i = 0;
            for (;i<n;i++){
                int ns = sum + a[i];
                if(s == ns) {
                    start = start+1;
                    end = i+1;
                    break;
                } else if(s < ns){
                    sum += a[i];
                    while (sum > s) {
                        sum -= a[start++];
                    }
                    if(sum == s) {
                        start = start+1;
                        end = i+1;
                        break;
                    }
                } else {
                    sum += a[i];
                }
            }

            if(i == n) {
                System.out.println(-1);
            } else {
                System.out.println(start+" "+end);
            }
        }
    }
}
