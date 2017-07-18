package com.ood.di;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ravinderk on 6/5/2017.
 */
public class NutsBolts {
    private static void mapNut2Bolt(int[] nuts, int[] bolts, int l, int r) {
        if(l >= r) {
            return;
        }

        int p = partitionBolts(nuts[r],bolts,l,r);
        partitionNuts(bolts[p],nuts,l,r);

        mapNut2Bolt(nuts,bolts, l, p-1);
        mapNut2Bolt(nuts,bolts, p+1, r);
    }

    private static int partitionBolts(int nut, int[] bolts, int l, int r) {
        List<Integer> bigs =  new LinkedList<>();
        List<Integer> smalls =  new LinkedList<>();
        int eqBolt = -1;
        for (int i = l ; i <=r; i++) {
            if(nut > bolts[i]) {
                smalls.add(bolts[i]);
            } else if(nut < bolts[i]){
                bigs.add(bolts[i]);
            } else {
                eqBolt = bolts[i];
            }
        }
        int p = l;
        while (!smalls.isEmpty()) bolts[p++] = smalls.remove(0);
        int i = p;
        bolts[i++]=eqBolt;
        while (!bigs.isEmpty()) bolts[i++] = bigs.remove(0);
        return p;
    }

    private static int partitionNuts(int bolt, int[] nuts, int l, int r) {
        List<Integer> bigs =  new LinkedList<>();
        List<Integer> smalls =  new LinkedList<>();
        int eqNut = -1;
        for (int i = l ; i <=r; i++) {
            if(bolt > nuts[i]) {
                smalls.add(nuts[i]);
            } else if(bolt < nuts[i]){
                bigs.add(nuts[i]);
            } else {
                eqNut = nuts[i];
            }
        }
        int p = l;
        while (!smalls.isEmpty()) nuts[p++] = smalls.remove(0);
        int i = p;
        nuts[i++]=eqNut;
        while (!bigs.isEmpty()) nuts[i++] = bigs.remove(0);
        return p;
    }

    public static void main(String[] args) {
        int[] nuts = new int[]{5,4,3,2,1};
        int[] bolts = new int[]{1,2,3,4,5};
        mapNut2Bolt(nuts, bolts, 0, nuts.length-1);
        Arrays.stream(nuts).forEach(n -> System.out.print(n+" "));
    }
}
