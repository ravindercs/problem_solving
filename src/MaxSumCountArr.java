import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class MaxSumCountArr {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(findMax(a,n));
            t--;
        }
    }

    private static int findMax(int[] a, int n) {
        int[] f = new int[n+1];
        for(int i = 0 ; i < n ; i++) {
            if(a[i] < n) {
                f[a[i]]++;
            } else {
                f[n]++;
            }
        }

        int count = 0;
        for(int i = n ; i > 1 ; i--) {
            count += f[i];

            if(count >= i) {
                return i;
            }
        }

        return -1;
    }
}
