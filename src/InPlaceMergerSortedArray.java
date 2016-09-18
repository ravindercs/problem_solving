import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class InPlaceMergerSortedArray {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] a = new int[m];
            int[] b = new int[n];
            for (int i = 0; i < m; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            mergeArray(a, m, b, n);
            for (int i = 0 ; i < m; i++) {
                System.out.print(a[i]+" ");
            }
            System.out.println();
            for (int i = 0 ; i < n; i++) {
                System.out.print(b[i]+" ");
            }
            System.out.println();

            t--;
        }
    }

    private static void mergeArray(int[] a, int m, int[] b, int n) {
        for (int i =0; i < m ; i++) {
            if(a[i] <= b[0]) {
                i++;
            } else {
                int t = a[i];
                a[i] = b[0];
                b[0] = t;
                sortArray(b, n);
            }
        }
    }

    private static void sortArray(int[] b, int n) {
        for (int i = 0 ; i < n-1; i++) {
            if(b[i] > b[i+1]) {
                int t = b[i];
                b[i] = b[i+1];
                b[i+1] = t;
            }
        }
    }
}
