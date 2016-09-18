import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class EvenSumSubArrCount {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(evenSumSubArrBF(a,n));
            System.out.println(evenSumSubArr(a,n));
            t--;
        }
    }

    private static int evenSumSubArrBF(int[] a, int n) {
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            int s = 0;
            for (int j = i ; j < n ; j++) {
                s += a[j];
                if(s%2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int evenSumSubArr(int[] a, int n) {
        int count = 0;
        int even = 0;
        int odd = 0;
        for (int i = 0 ; i < n ; i++) {
            if( (a[i] & 1) == 1 ) {
                count += odd;
                odd++;
            } else {
                even++;
                count += even;
            }
        }
        return count;
    }
}
