package com.ood.di;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 7/17/2017.
 */
public class FractionalKnapsack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            int w = s.nextInt();
            List<int[]> data = new ArrayList<>();
            for (int i = 0 ; i < n ; i++) {
                data.add(new int[]{s.nextInt(),s.nextInt()});
            }

            System.out.println(calculateMaxValue(data,n,w));
        }
    }

    private static double calculateMaxValue(List<int[]> data, int n, int w) {
        Collections.sort(data, (f, s) -> (f[0]/(float)f[1] - s[0]/(float)s[1] > 0 ? -1 : 1) );
        double maxValue = 0.0;
        double wt = 0.0;
        for(int i = 0 ; i < n ; i++) {
            int wi = data.get(i)[1];
            int vi = data.get(i)[0];
            if(wt + wi <= w) {
                maxValue += vi ;
                wt += wi;
            } else if(wt < w) {
                maxValue += vi*(w-wt)/wi;
                break;
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        maxValue = Double.valueOf(df.format(maxValue));
        return maxValue;
    }
}
