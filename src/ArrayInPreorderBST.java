package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/15/2017.
 */
/*
Given an array, write a program that prints 1 if given array can represent preorder traversal of a BST, else prints 0.
 */
public class ArrayInPreorderBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0 ; i < n; i++) a[i] = sc.nextInt();

            System.out.println(isPreorderBST(a,0, n-1) ? 1 : 0);
        }
    }
    private static boolean isPreorderBST(int[] a,int l, int r) {
        if(l>=r) return true;
        int k = -1;
        for (int i = l+1; i <=r ; i++) {
            if (a[i] > a[l]) {
                k = i - 1;
                break;
            }
        }
        if(k != -1) {
            for (int i = k + 1; i <= r; i++) {
                if (a[i] < a[l]) {
                    return false;
                }
            }
        }

        return k >= 0 && isPreorderBST(a,l+1,k) && isPreorderBST(a,k+1,r);
    }
}
