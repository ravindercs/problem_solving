package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 7/11/2017.
 */
public class LostMoney {
    static int[] notes = new int[]{1,2,5,10,20,50,100,500,1000};
//    public static void main (String[] args) {
//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        while(t-->0) {
//            int n = s.nextInt();
//            int m = s.nextInt();
//            System.out.println(minCoins(n,m));
//        }
//    }

    private static int minCoins(int n, int m) {
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        for(int i = 0 ; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        int lastMNotesValue = 0;
        for(int v = 1; v <= n; v++) {
            for (int i = 0; i < notes.length; i++) {
                if (notes[i] <= v) {
                    int res = dp[v - notes[i]];
                    if (res != Integer.MAX_VALUE && res + 1 < dp[v]) {
                        dp[v] = res + 1;
                    }
                }
            }
            if(dp[v] <= m) {
                lastMNotesValue = v;
            }
        }
        return n - lastMNotesValue;
    }

    public static void main(String[] args) {
        editDistance("geek","gesek");
        editDistance("cat","cut");
        editDistance("sunday","saturday");
    }

    private static void editDistance(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = 0 ; i <= s1.length(); i++) {
            for (int j = 0 ; j <= s2.length(); j++) {
                if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], //Insert
                            Math.min(dp[i-1][j],//Remove
                                    dp[i-1][j-1]//Replace
                            ));
                }
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);
    }

    private static int editDistance(String s1, String s2, int m, int n, int[][] dp) {
        if(m == 0) return n;
        if(n == 0) return m;
        if(dp[m][n] != 0) return dp[m][n];

        if(s1.charAt(m-1) == s2.charAt(n-1)) {
            return editDistance(s1,s2,m-1,n-1,dp);
        }

        dp[m][n] = 1 + Math.min( editDistance(s1,s2,m-1,n,dp), //Delete
                       Math.min(
                                editDistance(s1,s2,m-1,n-1,dp), //Replace
                                editDistance(s1,s2,m,n-1,dp) //Insert
        ));

        return dp[m][n];
    }
}
