package com.ood.di;

/**
 * Created by ravinderk on 7/14/2017.
 */
public class Partition2SubsetWithMinSumDiff {
    /*
    S(k,s) = S(k-1,S
    //Can I divide the set starting with difference 0...,
    If only one element then min diff is value of element.
    If two value is diff of two-zero or one-one
    If three.... Take one ....Divide rest .... Apply that element to all possible sets...

    Create recursion :

    miniDiff = S(a{},b{},n)
    if(n == 1) return a[0];

    int incDiff = S({},n-1)
    int excDiff =


    minimize the diff of sum .....

    S(i,ST) = Min(S(i-1,ST-a[i]), S(i,ST))

     */
    public static void main(String[] args) {

    }
}
