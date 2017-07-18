package com.ood.di;

import java.util.Stack;

/**
 * Created by ravinderk on 7/14/2017.
 */

/*
  0 e k e
0 0 0 0 0
g 0 0 0 0
e 0 1 1 1
e 0 1 1 2
k 0 1 2 2
 */
public class ShortestSuperSequence {
    public static void main(String[] args) {
        lcs("AGGTAB","GXTXAYB");
    }

    private static void lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] lcs = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for(int j = 1 ; j <=n ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        Stack<Character> ss = new Stack<>();
        int i = m, j = n;
        while(i > 0  && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ss.push(s1.charAt(i-1));
                i--;j--;
            } else if(lcs[i-1][j] >= lcs[i][j-1]){
                ss.push(s1.charAt(i-1));i--;
            } else {
                ss.push(s2.charAt(j-1));j--;
            }
        }

        while (j > 0) {
            ss.push(s2.charAt(j-1));j--;
        }

        while (i > 0) {
            ss.push(s1.charAt(i-1));i--;
        }

        while (!ss.isEmpty()) {
            System.out.print(ss.pop());
        }
        System.out.println();
    }
}
