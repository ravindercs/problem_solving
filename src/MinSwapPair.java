import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class MinSwapPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] pairs = new int[n];

            for (int i = 0; i < n; i++) {
                pairs[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(minSwap(arr, pairs, 0, n));
            t--;
        }
    }

    //pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
    //arr[] = {3, 5, 6, 4, 1, 2}
    private static int minSwap(int[] a, int pairs[], int i, int n) {
        if(i >= n-1) {
            return 0;
        }

        int firstIndex = i;
        int secondIndex = i+1;
        int result = 0;
        if(a[i] != pairs[a[i]]) {
            return 1;
        }
        swap(a, firstIndex, pairs[firstIndex]);
        result++;
        result += minSwap(a, pairs, firstIndex, n);

        return firstIndex;
    }

    private static void swap(int[] a, int i , int j) {
        int t = a[i];
        a[i] = a[j];
        a[j]= t;
    }
}
