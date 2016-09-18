import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class ZigZagReorderArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            reorderArray(arr, n);
            for(int i = 0 ; i < n ; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            t--;
        }
    }

    private static void reorderArray(int[] a, int n) {
        if(n < 2) {
            return;
        }
        boolean isStateIncrement = false;

        if(a[0] > a[1]) {
            swap(a,0,1);
        }

        for (int i = 1 ; i < n-1; i++) {
            if(isStateIncrement) {
                if(a[i] > a[i+1]) {
                    swap(a,i,i+1);
                    if(a[i-1] < a[i]) {
                        swap(a,i,i-1);
                    }
                }
                isStateIncrement = false;
            } else {
                if(a[i] < a[i+1]) {
                    swap(a,i,i+1);
                    if(a[i-1] > a[i]) {
                        swap(a,i,i-1);
                    }
                }
                isStateIncrement = true;
            }
        }
    }

    private static void swap(int[] a, int i , int j) {
        int t = a[i];
        a[i] = a[j];
        a[j]= t;
    }
}
