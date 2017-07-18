package com.ood.di;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            char[] number = Integer.toString(sc.nextInt()).toCharArray();

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
                continue;
            }

            // II) Find the smallest digit on right side of (i-1)'th digit that is
            // greater than number[i-1]
            int x = number[i-1], smallest = i;
            for (j = i+1; j < n; j++)
                if (number[j] > x && number[j] < number[smallest])
                    smallest = j;

            // III) Swap the above found smallest digit with number[i-1]
            char temp = number[smallest];
            number[smallest] = number[i-1];
            number[i-1]=temp;

            // IV) Sort the digits after (i-1) in ascending order
            Arrays.sort(number,i, n);

            System.out.println(new String(number));
        }
    }
}