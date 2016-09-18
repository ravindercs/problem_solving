import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class SubArrayAndSubSequence {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            subArray(a, n);
            subSequence(a, n);
            t--;
        }
    }

    private static void subArray(int[] a, int n) {
        for (int i = 0 ; i < n; i++) {
            for (int j = i ; j < n; j++) {
                for (int k = i ; k <=j ; k++) {
                    System.out.print(a[k]+" ");
                }
                System.out.println();
            }
        }
    }

    private static void subSequence(int a[], int n)
    {
        double size = Math.pow(2,n);

        for (int i=1; i < size; i++)
        {
            for (int j = 0 ; j < n ; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(a[j]+" ");
                }
            }
            System.out.println();
        }
    }
}
