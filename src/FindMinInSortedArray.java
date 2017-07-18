package com.ood.di;

/**
 * Created by ravinderk on 6/4/2017.
 */
public class FindMinInSortedArray {
    //[4,3,2,1]  => [3,2,1,4] //Not possible case or handle this case??
    //Assume ascending order
    //Simple solution O(n) find min in array.
    //Rotated Index
    //Left of rotated index are all greater than right
    //Modified binary search can be used to find the index
    private static int findMin(int[] a) {

        if (a == null || a.length == 0) return -1;

        if (a.length == 1) return a[0];

        int l = 0, r = a.length - 1;//l = 0 , r = 8;

        if (a[l] < a[r]) return a[l];
        //{0,1,2,3,4,5}
        //{2,3,4,5,6,1}
        while (l <= r) { //l = 5 , r = 5;
            int mid = l + (r - l) / 2; //mid = 5;
            if (mid == l || mid == r) return a[l] < a[r] ? a[l] : a[r];
            if (a[mid - 1] > a[mid] && a[mid] < a[mid + 1]) return a[mid];
            if (a[mid] > a[l] && a[mid] > a[r]) l = mid + 1;
            else if (a[mid] < a[l] && a[mid] < a[r]) r = mid - 1;
        }

        return -1;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int arr1[] = {5, 6, 1, 2, 3, 4};
        System.out.format("The minimum element is %d\n", findMin(arr1));

        int arr2[] = {1, 2, 3, 4};
        System.out.format("The minimum element is %d\n", findMin(arr2));

        int arr3[] = {1};
        System.out.format("The minimum element is %d\n", findMin(arr3));

        int arr4[] = {1, 2};
        System.out.format("The minimum element is %d\n", findMin(arr4));

        int arr5[] = {2, 1};
        System.out.format("The minimum element is %d\n", findMin(arr5));

        int arr6[] = {5, 6, 7, 1, 2, 3, 4};
        System.out.format("The minimum element is %d\n", findMin(arr6));

        int arr7[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.format("The minimum element is %d\n", findMin(arr7));

        int arr8[] = {2, 3, 4, 5, 6, 7, 8, 1};
        System.out.format("The minimum element is %d\n", findMin(arr8));

        int arr9[] = {3, 4, 5, 1, 2};
        System.out.format("The minimum element is %d\n", findMin(arr9));
    }
}
