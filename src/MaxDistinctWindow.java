package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2017.
 */
public class MaxDistinctWindow {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        while(t-->0) {
            System.out.println(longestDistinctCharWindow(s.next()));
        }
    }

    public static String smallestWindow(String str, String txt) {
        int[] h_txt = new int[26];
        int c_txt = txt.length(); //count of distinct characters
        for (int i = 0 ; i < txt.length(); i++) {
            h_txt[txt.charAt(i)-'a']++;
        }

        int c_str = 0;
        int[] h_str = new int[26];
        int start = 0;
        int minlen = Integer.MAX_VALUE;
        int mi = -1;
        int mj = -1;
        for (int i = 0 ; i < str.length(); i++) {
            int chi = str.charAt(i)-'a';
            h_str[chi]++;
            if(h_txt[chi] != 0 && h_str[chi] <= h_txt[chi]) {
                c_str++;
            }

            if(c_str == c_txt) {
                int sti = str.charAt(start) - 'a';
                while (h_txt[sti] == 0 || h_str[sti] > h_txt[sti]) {
                    start++;
                    h_str[sti]--;
                    sti = str.charAt(start) - 'a';
                }

                if(minlen > i - start + 1) {
                    minlen = i - start + 1;
                    mi = start;
                    mj = i;
                }
            }
        }

        return mi == -1 ? "-1" : str.substring(mi,mj+1);
    }

    public static int maxDistinctWindow(String str) {
        int[] h_txt = new int[26];
        for (int i = 0 ; i < str.length(); i++) {
            h_txt[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < 26; i++) {
            if(h_txt[i] != 0) sb.append((char)('a'+i));
        }

        return smallestWindow(str,sb.toString()).length();
    }

    public static int longestDistinctCharWindow(String str) {
        boolean[] v = new boolean[26];
        int mx = Integer.MIN_VALUE;
        int cmx = 0;
        int start = 0;
        for (int i = 0 ; i < str.length(); i++) {
            int chi = str.charAt(i) - 'a';
            if(v[chi]) {
                while (str.charAt(start) != str.charAt(i)) {
                    v[str.charAt(start)-'a'] = false;
                    start++;
                }
                start++;
                cmx = i - start + 1;
            } else {
                v[str.charAt(i)-'a'] = true;
                cmx++;
                mx = mx > cmx ? mx : cmx;
            }
        }
        return mx;
    }
}
