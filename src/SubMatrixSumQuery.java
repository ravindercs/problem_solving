import java.util.Stack;

/**
 * Created by ravinderk on 7/18/2016.
 */
public class SubMatrixSumQuery {

    public static void main(String[] args) {
        int[][] a = preProcess(new int[][]
                {{1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4} });

        printMat(a);

        printSum(a, 0 , 0 , 1 , 1);
        printSum(a, 1 , 1 , 2 , 2);
        printSum(a, 1 , 1 , 3 , 3);
    }
//
//            1  3  6  10 16
//            6  11 22 27 35
//            10 21 39 49 62
//            12 27 53 72 89
    private static void printSum(int[][] a, int i, int j, int k, int l) {
        int res = a[k][l];
        if(j > 0) {
            res = res - a[k][j-1];
        }
        if(i > 0) {
            res = res - a[i-1][l];
        }

        if( i > 0 && j > 0) {
            res += a[i-1][j-1];
        }
        System.out.println(res);
    }

    private static void printMat(int[][] a) {
        for (int[] r: a) {
            for (int e: r) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    private static int[][] preProcess(int[][] a) {
        int[][] sa = new int[a.length][a[0].length];
        sa[0][0] = a[0][0];
        for (int i = 1 ; i < a[0].length; i++) {
            sa[0][i] = sa[0][i-1] + a[0][i];
        }

        for (int i = 1; i < a.length; i++) {
            int s = 0;
            for (int j = 0 ; j < a[0].length; j++) {
                sa[i][j] = s + sa[i-1][j] + a[i][j];
                s += a[i][j];
            }
        }

        return sa;
    }
}
