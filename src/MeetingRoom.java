package com.ood.di;

import java.util.*;

/**
 * Created by ravinderk on 7/16/2017.
 */
public class MeetingRoom {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            List<int[]> meetings = new ArrayList<>();
            for (int i = 0 ; i < n ; i++) {
                meetings.add(new int[]{s.nextInt(),0,i+1});
            }
            for (int i = 0 ; i < n ; i++) {
                meetings.get(i)[1] = s.nextInt();
            }

            maxMeetings(meetings);
        }
    }

    private static int maxMeetings(List<int[]> meetings) {
        Collections.sort(meetings, (f,s) -> f[1] - s[1]);
        int max = 1;
        int prevFinish = meetings.get(0)[1];
        System.out.print(meetings.get(0)[2]+" ");
        for (int i = 1 ; i < meetings.size() ; i++) {
            if(meetings.get(i)[0] >= prevFinish) {
                max++;
                prevFinish = meetings.get(i)[1];
                System.out.print(meetings.get(i)[2]+" ");
            }
        }
        System.out.println();
        return max;
    }
}
