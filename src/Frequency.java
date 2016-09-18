import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            findCounts(arr, n);
            t--;
        }
    }
    //{2, 3, 3, 2, 5}
    // Function to find counts of all elements present in
// arr[0..n-1]. The array elements must be range from
// 1 to n
    private static void findCounts(int[] arr, int n)
    {
        // Traverse all array elements
        int i = 0;
        while (i<n)
        {
            // If this element is already processed,
            // then nothing to do
            if (arr[i] <= 0)
            {
                i++;
                continue;
            }

            // Find index corresponding to this element
            // For example, index for 5 is 4
            int elementIndex = arr[i]-1;

            // If the elementIndex has an element that is not
            // processed yet, then first store that element
            // to arr[i] so that we don't loose anything.
            if (arr[elementIndex] > 0)
            {
                arr[i] = arr[elementIndex];

                // After storing arr[elementIndex], change it
                // to store initial count of 'arr[i]'
                arr[elementIndex] = -1;
            }
            else
            {
                // If this is NOT first occurrence of arr[i],
                // then increment its count.
                arr[elementIndex]--;

                // And initialize arr[i] as 0 means the element
                // 'i+1' is not seen so far
                arr[i] = 0;
                i++;
            }
        }

        for (i=0; i<n; i++)
            System.out.println(i+1 + "->" + Math.abs(arr[i]));
    }
}
