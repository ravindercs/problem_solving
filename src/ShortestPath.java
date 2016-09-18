import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class ShortestPath {
    public static void main(String[] args) {
        findShortestPath(new int[][]{
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }}, 0 ,0, 3, 4);
    }

    private static void findShortestPath(int[][] a, int i, int j, int di, int dj) {
        if(a != null && a.length <= 0) {
            return;
        }
        print(a);
        System.out.println();
        boolean[][] T = new boolean[a.length][a[0].length];
        T[i][j] = true;
        q.add(new Data(i,j,0));
        System.out.println(findPath(a, T, di, dj));
    }

    private static Queue<Data> q = new ArrayDeque<Data>();

    private static int findPath(int[][] a,boolean[][] T, int di, int dj) {
        while (!q.isEmpty()) {
            Data p = q.remove();
            int i = p.i;
            int j = p.j;

            if(i == di && j == dj) {
                return p.d;
            }

            for (int[] move : moves) {
                int nextI = i + move[0];
                int nextJ = j + move[1];

                if (isSafe(a, nextI, nextJ) && a[nextI][nextJ] == 1 && !T[nextI][nextJ]) {
                    T[nextI][nextJ] = true;
                    q.add(new Data(nextI, nextJ, p.d + 1));
                }
            }
        }

        return -1;
    }

    private static final int[][] moves = new int[][]{
            {-1,0},
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1},
            {-1,-1},
    };

    static class Data{
        int i,j,d;

        public Data(int d, int i, int j) {
            this.d = d;
            this.i = i;
            this.j = j;
        }
    }

    private static boolean isSafe(int[][] a, int i, int j) {
        return i >= 0 && i < a.length && j >= 0 && j < a[0].length;
    }

    private static void print(int[][] a) {
        for (int i = 0 ; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}