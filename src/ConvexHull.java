package com.ood.di;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by ravinderk on 6/14/2017.
 */
/*
Convex Hull of a set of points, in 2D plane,
 is a convex polygon with minimum area such that each point
 lies either on the boundary of polygon or inside it.
  Now given a set of points the task is to find the convex hull of points.

Input:
The first line of input contains an integer T denoting the no of test cases.
 Then T test cases follow. Each test case contains an integer N denoting the no of points.
  Then in the next line are N*2 space separated values denoting the points ie x and y.

Output:
For each test case in a new line print the points x and y of the convex hull separated by a space in sorted order where every pair is separated from the other by a ','. If no convex hull is possible print -1.
 */

/*
2
3
1 2 3 1 5 6
3
1 2 4 4 5 1
|         .
|
|       *
|
| *.
|     .   *
|_ _ _ _ _ _
Quick Hull
Many solutions
 */
public class ConvexHull {
    /// 1 2 3 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] s = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());
            int[] count = new int[26];
            for(int i =0;i<s.length;i++) {
                count[s[i]-'a']++;
            }

            for (int i =0 ; i < k; i++) {
                int max = 0;
                int maxi = -1;
                for (int j = 0 ; j < 26; j++) {
                    if(max<count[j]) {
                        max = count[j];
                        maxi=j;
                    }
                }
                if(maxi >= 0)
                    count[maxi]--;
            }

            int sq = 0;
            for (int i =0; i<26; i++) {
                sq += count[i]*count[i];
            }
            System.out.println(sq);
        }
    }
}
