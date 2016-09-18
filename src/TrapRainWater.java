import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class TrapRainWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(trapWater(arr, n));
            t--;
        }
    }

    //{3, 0, 0, 2, 0, 4}
    //{3, 3, 3, 3, 3, 4}
    //{4, 4, 4, 4, 4, 4}
    //[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    //[0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
    //[3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]
    private static int trapWater(int[] a, int n) {
        int volume = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        right[n-1] = a[n-1];
        for (int i = 1 ; i < n ; i++ ) {
            if(a[i] > left[i-1]) {
                left[i] = a[i];
            } else {
                left[i] = left[i-1];
            }
        }

        for (int i = n-2 ; i >=0 ; i-- ) {
            if(a[i] > right[i+1]) {
                right[i] = a[i];
            } else {
                right[i] = right[i+1];
            }
        }

        for (int i = 0 ; i < n ; i++) {
            volume += Math.min(left[i], right[i]) - a[i];
        }

        return volume;
    }
}
