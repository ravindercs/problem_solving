package com.ood.di;

/**
 * Created by ravinderk on 6/10/2017.
 */
/*
Generate all binary strings without consecutive 1’s
Given a integer K. Task is Print All binary string of size K (Given number).
 */
/*
k=1 => 0, 1
k=2 => 00, 01, 10
k =3 => 000, 001, 010, 100, 101
k =4 => 0000, 0001, 0010, 0100, 0101, 1000, 1001, 1010
k =5 =>
Observations:
Recursive nature
 */
public class PrintBinary {
    public static void main(String[] args) {
        generateAllStrings(3);
        generateAllStrings(4);
    }

    private static void generateAllStrings(int k) {
        char[] str = new char[k];

        str[0] = '0';
        generateAllStrings(k, str, 1);
        str[0] = '1';
        generateAllStrings(k, str, 1);
    }

    private static void generateAllStrings(int k, char[] str, int n) {
        if(n == k) {
            System.out.println(new String(str)); return;
        }

        if(str[n-1]=='0') {
            str[n] = '1';
            generateAllStrings(k, str, n+1);
        }

        str[n] = '0';
        generateAllStrings(k, str, n+1);
    }
}
