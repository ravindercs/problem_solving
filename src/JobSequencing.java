package com.ood.di;

import java.util.*;

/**
 * Created by ravinderk on 7/17/2017.
 */
public class JobSequencing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            List<int[]> jobs = new ArrayList<>();
            for (int i = 0 ; i < n ; i++) {
                jobs.add(new int[]{s.nextInt(),s.nextInt(),s.nextInt()});
            }

            calculateMaxProfitJobs(jobs);
        }
    }
/*
3
4
1 4 20 2 1 10 3 1 40 4 1 30
5
1 2 100 2 1 19 3 2 27 4 1 25 5 1 15
79
1 23 400 2 100 143 3 31 191 4 64 291 5 30 140 6 5 23 7 63 137 8 91 443 9 97 403 10 99 28 11 62 463 12 87 114 13 10 486 14 73 489 15 73 468 16 67 248 17 19 218 18 42 1 19 8 406 20 44 489 21 45 48 22 63 359 23 36 305 24 53 284 25 8 4 26 64 221 27 66 250 28 35 328 29 36 359 30 16 60 31 26 135 32 7 396 33 52 401 34 97 112 35 6 392 36 100 202 37 91 315 38 61 326 39 19 213 40 9 326 41 16 124 42 99 34 43 74 85 44 61 461 45 43 176 46 72 121 47 10 31 48 16 14 49 31 264 50 25 236 51 55 76 52 37 445 53 90 497 54 22 361 55 62 83 56 38 277 57 6 436 58 10 431 59 20 170 60 91 315 61 98 263 62 35 359 63 93 450 64 72 75 65 66 496 66 10 220 67 72 98 68 17 313 69 47 138 70 73 8 71 72 211 72 84 278 73 46 446 74 8 18 75 67 451 76 32 164 77 65 266 78 23 209 79 67 394

 */
    private static void calculateMaxProfitJobs(List<int[]> jobs) {
        Collections.sort(jobs, (f, s) -> s[2] - f[2]);
        int n = jobs.size();
        boolean[] freeSlots = new boolean[n];
        int profit = 0;
        int totalJobs = 0;
        for (int i = 0 ; i < n ; i++) {
            int[] job = jobs.get(i);
            for (int j = Math.min(n, job[1]) - 1; j >= 0; j--) {
                if(freeSlots[j] == false) {
                    freeSlots[j] = true;
                    totalJobs++;
                    profit += job[2];
                    break;
                }
            }
        }

        System.out.println(totalJobs+" "+profit);
    }
}
