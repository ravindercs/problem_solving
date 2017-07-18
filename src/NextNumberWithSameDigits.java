package com.ood.di;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/4/2017.
 */
/*
Given a number n,
find the smallest number that has same set of digits as n and is greater than n.
 If x is the greatest possible number with its set of digits, then print “not possible”.

1) If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.
2) If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
3) For other cases, we need to process the number from rightmost side (why? because we need to find the smallest of all greater numbers)

218765 =>
*/
public class NextNumberWithSameDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            findNext(sc.next().toCharArray());
        }
    }

    // Given a number as a char array number[], this function finds the
// next greater number.  It modifies the same array to store the result
    static void findNext(char number[])
    {
        int n = number.length;
        int i, j;

        // I) Start from the right most digit and find the first digit that is
        // smaller than the digit next to it.
        for (i = n-1; i > 0; i--)
            if (number[i] > number[i-1])
                break;

        // If no such digit is found, then all digits are in descending order
        // means there cannot be a greater number with same set of digits
        if (i==0)
        {
            System.out.println("not possible");
            return;
        }

        // II) Find the smallest digit on right side of (i-1)'th digit that is
        // greater than number[i-1]
        int x = number[i-1], smallest = i;
        for (j = i+1; j < n; j++)
            if (number[j] > x && number[j] < number[smallest])
                smallest = j;

        // III) Swap the above found smallest digit with number[i-1]
        char t = number[smallest];
        number[smallest] = number[i-1];
        number[i-1]=t;

        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(number,i, n);

        System.out.println(new String(number));

        return;
    }}