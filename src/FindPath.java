import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int[] x = new int[]{1,0,-1,0};
    static int[] y = new int[]{0,1,0,-1};

    private static boolean findPathBFS(int[][] m, int i, int j) {
        boolean[][] v = new boolean[m.length][m[0].length];

        for(int k = 0 ; k < m.length; k++) {
            for (int l = 0; l< m[0].length; l++) {
                v[k][l] = false;
            }
        }

        return findPathUtilBFS(m, i, j, v);
    }

    static class Point { int i; int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    };

    private static boolean findPathUtilBFS(int[][] m, int ii, int jj, boolean[][] v) {
        if(ii < 0 || ii >= m.length ||
                jj < 0 || jj >= m[0].length) {
            return false;
        }

        List<Point> q = new LinkedList<>();
        q.add(new Point(ii,jj));

        while (!q.isEmpty()) {
            Point p = q.remove(0);
            int i = p.i;
            int j = p.j;

            if (!v[i][j]) {
                v[i][j] = true;

                for (int k = 0; k < x.length; k++) {
                    int ni = i + x[k];
                    int nj = j + y[k];
                    if(ni >= 0 && ni < m.length &&
                            nj >= 0 && nj < m[0].length) {
                        if (m[ni][nj] == 2) return true;

                        if (m[ni][nj] == 3) {
                            q.add(new Point(ni, nj));
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] m = new int[n][n];
            int si=0,sj=0;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    m[i][j] = sc.nextInt();
                    if(m[i][j] == 1) {
                        si = i;
                        sj = j;
                    }
                }
            }

            System.out.println(findPathBFS(m,si,sj) ? "1" : "0");
        }
    }
}