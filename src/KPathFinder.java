import java.util.Arrays;

/**
 * Created by ravinderk on 7/19/2016.
 */
public class KPathFinder {
    public static void main(String[] args) {
        System.out.println(findPaths(new int[][]{
                {1, 2, 3},
                {4, 6, 5},
                {3, 2, 1} },12));
    }

    private static int findPaths(int[][] a, int k) {
        int[][][] dp = new int[a.length][a[0].length][k+1];
        for (int i = 0 ; i < a.length; i++) {
            for (int j = 0 ; j < a[0].length; j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return findPaths(a,0,0,0,k,dp);
    }

    private static int findPaths(int[][] a, int i, int j, int coins, int k, int[][][] dp) {
        if(!isSafe(a,i,j)) return 0;

        if(i == a.length-1 && j == a[0].length -1) {
            if(a[i][j] + coins == k) return 1;
            else return 0;
        }

        coins += a[i][j];
        if(coins > k) {
            return 0;
        }

        if(dp[i][j][coins] != -1) {
            return dp[i][j][coins];
        }

        dp[i][j][coins] = findPaths(a, i + 1, j, coins, k, dp) + findPaths(a, i, j + 1, coins, k, dp);
        return dp[i][j][coins];
    }

    private static boolean isSafe(int[][] a, int i, int j) {
        return i >= 0 && i < a.length && j >= 0 && j < a[0].length ;
    }

}
