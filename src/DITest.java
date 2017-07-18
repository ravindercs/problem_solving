package com.ood.di;

/**
 * Created by ravinderk on 6/2/2017.
 */
public class DITest {
    public static void main(String[] args) {
        System.out.println(12345+":"+isPalim(12345));
        System.out.println(12321+":"+isPalim(12321));
    }

    private static boolean isPalim(int num) {
        if(num < 0)
            num = -num;

        return num == reverseNum(num);
    }

    private static int reverseNum(int num) {
        int rnum = 0;
        //12
        while (num/10 != 0) {
            rnum = 10*rnum + num%10;
            num = num/10;
        }

        rnum = rnum*10+num;

        return rnum;
    }
}
