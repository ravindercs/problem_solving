import java.util.Arrays;

/**
 * Created by ravinderk on 8/1/2016.
 */
public class KnightTour {
    private static int[] movesx = new int[] {  2, 1, -1, -2, -2, -1,  1,  2 };
    private static int[] movesy = new int[] {  1, 2,  2,  1, -1, -2, -2, -1 };

    public static void main(String[] args) {
        knightTour(4);
        knightTour(5);
        knightTour(6);
        knightTour(7);
        knightTour(8);
        knightTour(9);
    }

    private static void knightTour(int n) {
        int[][] sol = new int[n][n];
        for (int i = 0 ; i < sol.length; i++) {
            Arrays.fill(sol[i], -1);
        }
        sol[0][0] = 0;
        if(isKnightTour(sol, n, 0, 0, 1)) {
            for (int i = 0 ; i < sol.length; i++) {
                System.out.println(Arrays.toString(sol[i]));
            }
        } else {
            System.out.println("Not possible for "+n);
        }
    }

    private static boolean isKnightTour(int[][] sol, int n, int i, int j, int cur) {
        if(cur == n*n) {
            return true;
        }

        int nextx = 0;
        int nexty = 0;

        for (int k = 0 ; k < movesx.length; k++) {
            nextx = i + movesx[k];
            nexty = j + movesy[k];
            if(isSafe(nextx, nexty, n, sol)) {
                sol[nextx][nexty] = cur;
                if (isKnightTour(sol, n, nextx, nexty, cur + 1)){
                    return true;
                }else{
                    sol[nextx][nexty] = -1;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int i, int j ,int n, int[][] sol) {
        return i >= 0 && i < n && j >= 0 && j < n && sol[i][j] == -1;
    }
}
