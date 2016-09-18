import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class MaxUsingFlip {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            maxSum(a, n, m);
            t--;
        }
    }

    private static int maxSum(int[] a, int n, int m) {
        int len = 0;
        int maxLen = 0;
        int start = 0;
        int zc = 0;
        for (int i = 0 ; i < n ; i++) {
            if(a[i] == 1) {
                len++;
            } else if(a[i] == 0) {
                if(zc < m) {
                    zc++;
                    len++;
                } else {
                    int k = 0;
                    while (a[start+k] != 0) k++;
                    k++;
                    len = len - k;
                    start += k;
                }
            }
            if(maxLen < len) {
                maxLen = len;
            }
        }

        int end = start + len;
        for(int i = start; i < end; i++) {
            if(a[i] == 0) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
        return len;
    }
}
