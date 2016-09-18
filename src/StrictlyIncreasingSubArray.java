import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class StrictlyIncreasingSubArray {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(countSubArray(a, n));
            System.out.println(countIncreasing(a, n));
            t--;
        }
    }

    private static int countSubArray(int[] a, int n) {
        int count = 0;
        int left = 0;
        int right = 0;
        for (int i = 1 ; i < n; i++) {
            if(a[i] > a[i-1]) {
                count += i - left;
            } else {
                left = i;
            }
        }
        return count;
    }

    private static int countIncreasing(int arr[], int n)
    {
        int cnt = 0;  // Initialize result

        // Initialize length of current increasing
        // subarray
        int len = 1;

        // Traverse through the array
        for (int i=0; i < n-1; ++i)
        {
            // If arr[i+1] is greater than arr[i],
            // then increment length
            if (arr[i + 1] > arr[i])
                len++;

                // Else Update count and reset length
            else
            {
                cnt += (((len - 1) * len) / 2);
                len = 1;
            }
        }

        // If last length is more than 1
        if (len > 1)
            cnt += (((len - 1) * len) / 2);

        return cnt;
    }
}
