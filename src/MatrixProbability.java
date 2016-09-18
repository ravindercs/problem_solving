/**
 * Created by ravinderk on 7/5/2016.
 */
public class MatrixProbability {
    public static void main(String[] args) {
        int m = 5, n = 5; //Matrix size
        int N = 2 ;//Moves
        int i = 1, j = 1;
        System.out.println(findProbability(m, n, i, j, N));
    }

    //P = Total Number of desired outcomes / Total number of possible outcomes
    private static double findProbability(int m, int n, int i, int j, int N) {
        if(!isSafe(i,j,m,n)) {
            return 0.0;
        }
        if(N == 0) {
            return 1.0;
        }

        double p = 0.0;
        p += findProbability(m, n , i - 1, j, N-1)*.25;
        p += findProbability(m, n , i + 1, j, N-1)*.25;
        p += findProbability(m, n , i, j - 1, N-1)*.25;
        p += findProbability(m, n , i, j + 1, N-1)*.25;
        return p;
    }

    private static boolean isSafe(int i , int j , int m, int n) {
        return i >= 0 && i < m && j >=0 && j < n;
    }
}