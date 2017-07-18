package com.ood.di;

/**
 * Created by ravinderk on 7/12/2017.
 */
public class CountEqualSumBinaryNumbers {
    /*
    2xn => Count with same left half and right half sum
    count(n,diff) = count(n-1,diff)*2 + count(n-1,diff-1) + count(n-1,diff+1);
    n == 1 && diff == 0 return 2;
    n == 1 && abs(diff) == 1 return 1;

    00 10 01 11
    */

    /*
    1 2 3 4 1 2
    1 2 3 2 1 2

    if(a[i-1] < a[i] && d[i] < d[i-1] ) d[i] = d[i-1]+1;
    if(a[i+1] < a[i] && d[i] < d[i+1] ) d[i] = d[i+1]+1;

    C(i) = a[i] > a[i-1] C(i-1) + 1,
         = C(i-1)

     */
}
