package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/23/2017.
 */
/*
Given a string S, find the longest palindromic substring in S.

a
ab
abd
abcd

  a a a a b b a a
a 1
a   1
a     1
a       1
b         1
b            1
a              1
 */
public class LongestPalindromString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        while(t-->0) {
            System.out.println(maxPalindromSubsequence(s.next()));
        }
    }

    private static int maxPalindromSubsequence(String s) {
        if(s == null || s.trim().equals("")) return 0;

        if(s.length() == 1) return 1;
        if(s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) return 2;
            else return 1;
        }

        int n = s.length();
        int[][] p = new int[n][n];
        for (int i = 0 ; i < n ;i++) {
            p[i][i] = 1;
            if(i+1<n) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    p[i][i + 1] =  2;
                } else {
                    p[i][i + 1] =  1;
                }
            }
        }

        for(int k = 2; k < n; k++) {
            int j = k;
            for (int i = 0; j < n; i++,j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    p[i][j] = p[i+1][j-1]+2;
                } else {
                    p[i][j] = Math.max(p[i + 1][j], p[i][j - 1]);
                }
            }
        }

        return p[0][n-1];
    }

    private static String maxPalindromSubString(String s) {
        if(s == null || s.trim().equals("")) return null;
        if(s.length() == 1) return s;
        if(s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) return s;
            else return s.charAt(0) + "";
        }
        int n = s.length();
        int[][] p = new int[n][n];
        int maxi = 0;
        int maxj = 0;
        int maxlen = 1;
        for (int i = 0 ; i < n ;i++) {
            p[i][i] = 1;
            if(i+1<n) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    p[i][i + 1] =  2;
                    if(maxlen < 2) {
                        maxlen = 2;
                        maxi = i;
                        maxj = i + 1;
                    }
                } else {
                    p[i][i + 1] =  1;
                }
            }
        }

        for(int k = 2; k < n; k++) {
            int j = k;
            for (int i = 0; j < n; i++,j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j -i - 1 == p[i+1][j-1]) {
                        p[i][j] = p[i+1][j-1] + 2;
                        if(maxlen < p[i][j]) {
                            maxlen = p[i][j];
                            maxi = i;
                            maxj = j;
                        }
                        continue;
                    }
                }
                p[i][j] = Math.max(p[i+1][j], p[i][j-1]);
            }
        }

        return s.substring(maxi,maxj+1);
    }
}
