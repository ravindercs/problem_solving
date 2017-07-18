package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/14/2017.
 */
public class IsLandFinder {
    public static void main(String[] args) {
        IsLandFinder isLandFinder = new IsLandFinder();

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[n][m];
            int si=0,sj=0;
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    a[i][j] = sc.nextInt();
                }
            }

            System.out.println(isLandFinder.findIslands(a,n,m));
        }
    }

    /*you are required to complete this method*/
    int findIslands(int[][] A, int N, int M)
    {
        int islands = 0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(A[i][j] == 1) {
                    islands++;
                    dfs(A,N,M,i,j);
                }
            }
        }
        return islands;
    }

    void dfs(int[][] a,int n, int m, int i, int j){
        if(i<0 || i >= n || j<0 || j>=m) return;
        if(a[i][j] == 1) {
            a[i][j] = 0;
            dfs(a,n,m,i-1,j-1);
            dfs(a,n,m,i-1,j);
            dfs(a,n,m,i-1,j+1);
            dfs(a,n,m,i,j-1);
            dfs(a,n,m,i,j+1);
            dfs(a,n,m,i+1,j-1);
            dfs(a,n,m,i+1,j+1);
            dfs(a,n,m,i+1,j);
        }
    }

}
