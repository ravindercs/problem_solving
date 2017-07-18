package com.ood.di;

/**
 * Created by ravinderk on 6/15/2017.
 */
public class AtoI {
    public static void main(String[] args) {
        System.out.println(atoi("123"));
        System.out.println(atoi("12a"));
        System.out.println(atoi("12     "));
        System.out.println(atoi("     "));
        System.out.println(atoi("   -12  "));
        System.out.println(atoi("   +112  "));
    }

    private static int atoi(String s){
        if(s == null) return -1;
        s = s.trim();
        if(s.equals("")) return -1;
        int num = 0;
        int sign = 1;
        int i = 0;
        if(s.charAt(0) == '+') {
            i++;
        }

        if(s.charAt(0) == '-') {
            i++;
            sign = -1;
        }

        for (; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = 10*num + s.charAt(i) - '0';
            } else {
                return -1;
            }
        }
        return num*sign;
    }
}
