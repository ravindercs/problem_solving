import java.util.Arrays;

/**
 * Created by ravinderk on 8/1/2016.
 */
public class QSortOptimized {
    public static void main(String[] args) {

    }

    private static void qsort(int[] a) {
        if(a == null || a.length == 0) return;
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    /* This QuickSort requires O(Log n) auxiliary space in
   worst case. */
    private static void quickSort(int arr[], int low, int high)
    {
        while (low < high)
        {
        /* pi is partitioning index, arr[p] is now
           at right place */
            int pi = partition(arr, low, high);

            // If left part is smaller, then recur for left
            // part and handle right part iteratively
            if (pi - low < high - pi)
            {
                quickSort(arr, low, pi - 1);
                low = pi + 1;
            }

            // Else recur for right part
            else
            {
                quickSort(arr, pi + 1, high);
                high = pi - 1;
            }
        }
    }

    //{2,1,5,3,8,4}
    //{1,2,5,3,8,4}
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[0];

        while (low < high) {

        }

        return 0;
    }
}
