package com.ood.di;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ravinderk on 6/15/2017.
 */
/*
Given two numbers as stings s1 and s2 your task is to multiply them. You are required
to complete the function multiplyStrings which takes two strings
 s1 and s2 as its only argument and returns their product as strings.

 => 1234
   x 543
---------
    3702
   4936x
  6170xx
---------
  670062
---------
1. Reverse strings
2. For each char in smaller str create a new str with  multiply
3. Reverse the result
 */
/*
Mistakes I did
1. Char to number or number to char conversion
2. Handled case of zero wrongly
3. Did not remove initial zeros
 */
public class StringMultiply {
    public static void main(String[] args){
//        System.out.println("33x2="+multiply("33","2"));
//        System.out.println("11x23="+multiply("11","23"));
//        System.out.println("101*2="+multiply("101","2"));
//        System.out.println("001*2="+multiply("001","2"));
        System.out.println(multiply("52083596563020747301675788907803103673221533828580"
                ,"693374371396420295746491231813892451001330002224798547860064375810930").equals("36113431026949267273303016271954697029866096031299899566681635923342786471645975152815199153710384663804553265110379400"));

        System.out.println(multiply("4249994981639334615617229281247863772372537681364035850998024901200639083873","00503180179103594846929030337949"
                ).equals("2138513236050659684899247596343622586665960432905633868279280553999581331028904457156351582503310945796477"));
    }

    public static String multiply(String num1, String num2) {
        if(num2.length() < num1.length()) {
            String t = num1;
            num1 = num2;
            num2 = t;
        }

        num1 = sanitize(num1);
        num2 = sanitize(num2);
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        List<Character> mul = null;
        for (int i=0; i<num1.length(); i++) {
//            if(num1.charAt(i) != '0') {
                List<Character> m = multiplyToChar(num2, num1.charAt(i));
                if (mul == null) {
                    mul = m;
                } else {
                    addOffset(m, i);
                    addToResult(mul, m);
                }
//            }
        }

        StringBuilder res = new StringBuilder();
        mul.forEach(i->res.append(i));
        return res.reverse().toString();
    }

    private static String sanitize(String num1) {
        for(int i = 0 ; i < num1.length() ; i++) {
            if(num1.charAt(i) != '0') {
                num1 = num1.substring(i);
                break;
            }
        }
        return num1;
    }

    private static void addOffset(List<Character> m, int i) {
        while (i-->0){
            m.add(0,'0');
        }
    }

    private static void addToResult(List<Character> res, List<Character> m) {
        int carry = 0;
        int i = 0;
        for (; i < m.size(); i++) {
            if(i >= res.size()) {
                res.add('0');
            }
            int sum = res.get(i) - '0' + m.get(i) - '0' + carry;
            res.set(i, (char)(sum%10 + '0'));
            carry = sum/10;
        }

        while (carry > 0) {
            res.add((char)(carry%10+'0'));
            carry = carry/10;
        }
    }

    private static List<Character> multiplyToChar(String n, char c) {
        List<Character> res = new LinkedList<>();
        int carry = 0;
        for (int i = 0 ; i < n.length(); i++) {
            int  m = (n.charAt(i) - '0')*(c-'0') + carry;
            res.add((char)(m%10 + '0'));
            carry = m/10;
        }

        while (carry > 0) {
            res.add((char)(carry%10+'0'));
            carry = carry/10;
        }
        return res;
    }
}
