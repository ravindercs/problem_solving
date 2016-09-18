/**
 * Created by ravinderk on 7/18/2016.
*/

public class MaxSumSubMatrix {
    public static void main(String[] args) {
        calculateMaxSubMatrix(new int[][] {
                {1,  2,-1, 4},
                {-8,-3, 4, 2},
                {3,  8,10,-8},
                {-4,-1, 1,  7},
        },3);

        calculateMaxSubMatrix(new int[][]{{1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 8, 6, 7, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        },3);
    }

    private static void calculateMaxSubMatrix(int[][] a, int k) {
        int[][] sumCols = new int[a.length-k+1][a[0].length];
        int maxSum = Integer.MIN_VALUE;
        int ei = 0, ej = 0;

        for (int j = 0 ; j < a[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += a[i][j];
            }
            sumCols[0][j] = sum;
            for (int i = k ; i < a.length ; i++) {
                sumCols[i-k+1][j] = sumCols[i-k][j] - a[i-k][j] + a[i][j];
            }
        }

        //printMat(sumCols);

        for (int i = k-1 ; i < a.length; i++) {
            int sum = 0;
            for (int j = 0 ; j < k; j++) {
                sum += sumCols[i-k+1][j];
            }

            if(sum > maxSum) {
                maxSum = sum;
                ei = i;
                ej = k-1;
            }

            for (int j = k ; j < a[0].length; j++) {
                sum = sum - sumCols[i-k+1][j-k] + sumCols[i-k+1][j];
                if(sum > maxSum) {
                    maxSum = sum;
                    ei = i;
                    ej = j;
                }
            }
        }

        //System.out.println(maxSum);

        for (int i = ei-k+1; i <= ei; i++) {
            for(int j = ej-k+1; j <= ej; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void printMat(int[][] a) {
        for (int i = 0 ; i < a.length; i++) {
            for (int j = 0 ; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

}
