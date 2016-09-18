import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ravinderk on 7/19/2016.
 */
public class LongestPathFinder {
    public static void main(String[] args) {
        System.out.println(findPaths(new int[][]{
                {2, 1, 9},
                {4, 3, 8},
                {5, 6, 7}}));
    }

    private static Point[] moves = new Point[] {
            new Point(-1,0,1),
            new Point(0,1,1),
            new Point(1,0,1),
            new Point(0,-1,1)
    };
    static class Point {
        int i,j,d;

        public Point(int i, int j, int d) {
            this.d = d;
            this.i = i;
            this.j = j;
        }
    }
    private static int findPaths(int[][] a) {
        int maxLen = 0;
        Stack<Point> s = new Stack<Point>();
        int[][] dp = new int[a.length][a[0].length];
        for (int[] r : dp) {
            Arrays.fill(r,-1);
        }
        for(int i = 0 ; i < a.length; i++) {
            for(int j = 0 ; j < a[0].length; j++){
                s.push(new Point(i,j,1));
                int len = 0;
                while (!s.empty()) {
                    Point p = s.pop();
                    for(Point move : moves) {
                        int ni = p.i+move.i;
                        int nj = p.j+move.j;
                        if(isSafe(a, ni, nj)) {
                            int nd = p.d + move.d;
                            if (a[p.i][p.j] + 1 == a[ni][nj]) {
                                if (dp[ni][ni] != -1) {
                                    len += dp[ni][nj]+1;
                                    continue;
                                }
                                len = Math.max(len, nd);
                                s.push(new Point(ni, nj, nd));
                            }
                        }
                    }
                }

                dp[i][j] = len;
                maxLen = Math.max(len, maxLen);
            }
        }

        return maxLen;
    }

    private static boolean isSafe(int[][] a, int i, int j) {
        return i >= 0 && i < a.length && j >= 0 && j < a[0].length ;
    }

}
