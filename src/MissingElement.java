import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class MissingElement {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n-1];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n-1; i++) {
                b[i] = sc.nextInt();
            }
            System.out.println(getMissingElement(a, b, n));
            t--;
        }
    }

    private static int getMissingElement(int[] a, int[] b, int n) {
        int e = 0;

        for(int i = 0; i < n ; i ++) {
            e^=a[i];
        }

        for(int i = 0; i < n-1 ; i ++) {
            e^=b[i];
        }

        return e;
    }
}
