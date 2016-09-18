import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class SmallestRange {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] a = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0 ; j < n ; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            findRange(a,k,n);
            t--;
        }
    }

    private static void findRange(int[][] a, int k, int n) {

    }
}
