import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class InversionCount3 {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(findInversionCount(a, n));
            t--;
        }
    }

    private static int findInversionCount(int[] a, int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if(j < i && a[i] < a[j]) {
                    left[i] += 1;
                }
                if(j > i && a[i] > a[j]) {
                    right[i] += 1;
                }
            }
        }

        int count = 0;
        for(int i = 1 ; i < n ; i++) {
            count += left[i] * right[i];
        }
        return count;
    }
}
