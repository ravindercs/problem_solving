package com.ood.di;

import java.util.*;

/**
 * Created by ravinderk on 6/18/2017.
 */
public class StreamMedian {
    private static PriorityQueue<Integer> minQ = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int median = 0;
        while (t-->0){
            median = median(median,sc.nextInt());
            System.out.println(median);
        }
    }

    private static int median(int m, int i) {
        int sz = minQ.size() - maxQ.size();
        if(sz == 0) {
            if(m > i) {
                maxQ.add(i);
                m = maxQ.peek();
            } else {
                minQ.add(i);
                m = minQ.peek();
            }
        } else if(sz > 0) {
            if(i > m) {
                maxQ.add(minQ.poll());
                minQ.add(i);
            } else {
                maxQ.add(i);
            }
            m =  (maxQ.peek() + minQ.peek())/2;
        } else {
            if(i > m) {
                minQ.add(i);
            } else {
                minQ.add(maxQ.poll());
                maxQ.add(i);
            }
            m =  (maxQ.peek() + minQ.peek())/2;
        }

        return m;
    }
}
