package com.ood.di;

import java.util.*;

/**
 * Created by ravinderk on 6/22/2017.
 */
/*
2
1 2
3 4
3
1 2 3
4 5 6
6 7 8

31  100 65  12  18
10  13  47  157 6
100 113 174 11  33
88  124 41  20  140
99  32  111 41  20


int (0,0)->(i,j)

 */
public class MinCostPath {

    private int g_min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0 ; i < n ; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = s.nextInt();
                }
            }
            System.out.println(new MinCostPath().djikstraMinPath(a,n));
        }
    }

    private int djikstraMinPath(int[][] a, int n) {
        boolean[][] v = new boolean[n][n];
        int[][] d = new int[n][n];
        //Init all dest nodes to inifinity
        for (int i = 0 ; i < n ; i++) {
            for(int j = 0; j < n; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }

        //Priority queue to pick next best
        PriorityQueue<int[]> u = new PriorityQueue<>((f,s) -> f[2]-s[2]);
        u.add(new int[]{0,0,a[0][0]});
        d[0][0] = a[0][0];

        int[] x = new int[]{-1,0,1,0};
        int[] y = new int[]{ 0,1,0,-1};

        while (!u.isEmpty()) {
            //get min
            int[] cur = u.remove();
            v[cur[0]][cur[1]] = true;
            for (int i = 0 ; i < 4 ; i++) {
                int ni = cur[0] + x[i];
                int nj = cur[1] + y[i];

                if(ni < 0 || ni >= n || nj < 0 || nj >= n) {
                    continue;
                }

                int dist = d[cur[0]][cur[1]] + a[ni][nj];

                //Update if sorter path is found
                if(d[ni][nj] > dist) {
                    d[ni][nj] = dist;
                }

                //Check if destination has arrived
                if(ni == n-1 && nj == n-1) {
                    u.clear();
                    break;
                }

                //If unvisited add to unsettled nodes
                if(!v[ni][nj]) {
                    u.add(new int[]{ni,nj,d[ni][nj]});
                }
            }
        }

        return d[n-1][n-1];
    }


    private void dfs(int[][] a, int n) {
        g_min = Integer.MAX_VALUE;
        boolean[][] v = new boolean[n][n];
        dfsUtil(a,v,0,0,n,0);
        System.out.println(g_min);
    }

    private void dfsUtil(int[][] a, boolean[][] visited, int i, int j, int n, int sum) {
        if(i>=n || j >= n || i<0 || j<0) {
            return;
        }

        if(!visited[i][j]) {
            sum += a[i][j];
            if (i == n - 1 && j == n - 1) {
                g_min = Math.min(g_min, sum);
                return;
            }

            if(g_min > sum) {
                visited[i][j] = true;
                List<int[]> ma = new LinkedList<>();
                if(j+1 <n && !visited[i][j+1]) {
                    ma.add(new int[]{i, j + 1, a[i][j + 1]});
                }
                if(i+1<n && !visited[i+1][j]) {
                    ma.add(new int[]{i + 1, j, a[i + 1][j]});
                }
                if(j-1>=0 && !visited[i][j-1]) {
                    ma.add(new int[]{i, j - 1, a[i][j - 1]});
                }
                if(i-1>=0 && !visited[i-1][j]) {
                    ma.add(new int[]{i - 1, j, a[i - 1][j]});
                }
                Collections.sort(ma, (o1,o2) ->  o1[2]-o2[2]);
                final int fsum = sum;
                ma.forEach( m -> dfsUtil(a, visited, m[0], m[1], n, fsum));

                visited[i][j] = false;
            }
        }
    }
}
/*
32 88 86 4 79 5 59 62 37

32 - > 36, 120  -> 36 ->

1 -> 2 => (0,1)
2 -> 3 => (00,01,10)
3 -> 5 => (000,001,010,100,101)
4 -> 8 => (0000,0001,0010,0100,0101,1000,1001,1010)
5 -> 13 => (00000,00001,00010,00100,00101,01000,01001,01010,10000,10001,10010,10100,10101)

 */