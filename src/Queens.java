import java.util.*;

/**
 * Created by ravinderk on 8/1/2016.
 */
public class Queens {
    public static void main(String[] args) {
        placeQueens(4);
        placeQueens(8);
    }

    private static void placeQueens(int n) {
        int[][] sol = new int[n][n];
        if(placeQueens(sol, 0, n)) {
            for (int[] a: sol) {
                System.out.println(Arrays.toString(a));
            }
        } else {
            System.out.println("Not Possible");
        }
    }

    private static boolean placeQueens(int[][] sol, int row, int n) {
        if(row == n) {
            return true;
        }

        for (int k = 0 ; k < n; k++) {
            if(isSafe(sol, row, k, n)) {
                sol[row][k] = 1;
                if (placeQueens(sol, row + 1, n)) {
                    return true;
                }
                //Backtrack
                sol[row][k] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int board[][], int row, int col, int N)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check upper diagonal on right side */
        for (i=row, j=col; i>=0 && j<N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }
}
