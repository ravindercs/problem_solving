package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/16/2017.
 */
/*
A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
You are an FBI agent. You have to determine the total number of ways that message can be decoded.

123 = > 123 => 1 2 3 => 3
1221 = > 1 221 => 12 21 => 5
7695 => 7 6 9 5 => 1
10234 =>

 */
public class FBIDecoder {
    public static void main(String[] args) {
//        System.out.println(fbiDecode("123"));
//        System.out.println(fbiDecode("1231"));
//        System.out.println(fbiDecode("12031"));
    }

    private static int fbiDecode(String s) {
        //Leading, trailing, two or more continuous zeros
        //Empty string have one decoding
        if(s == null || s.length() == 0) {
            return 1;
        }

        if(s.charAt(0) == '0' || s.charAt(s.length()-1) == '0') {
            return -1;
        }

        return fbiDecodeRec(s);
    }

    private static int fbiDecodeRec(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) {
            return s.charAt(0) != '0' ? 1 : 0;
        }

        if(s.charAt(0) > '2' || (s.charAt(0) == '2' && s.charAt(1) > '7') ) {
            return 1+ fbiDecodeRec(s.substring(1));
        } else {
            return 2 + fbiDecodeRec(s.substring(1));
        }
    }
}
