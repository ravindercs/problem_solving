package com.ood.di.HuffmanTree;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2017.
 */
public class GFG {
    private char data;
    private int freq;
    private int index;
    private GFG left, right;

    public GFG(char data, int freq, int index) {
        this.data = data;
        this.freq = freq;
        this.index = index;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            String chars = s.next();
            int[] a = new int[chars.length()];
            for (int i = 0 ; i < chars.length(); i++) {
                a[i] = s.nextInt();
            }

            buildHuffmanTree(a, chars);
        }
    }

    private static void buildHuffmanTree(int[] a, String chars) {
        PriorityQueue<GFG> pq = new PriorityQueue<>((f,s) -> {
            return f.freq - s.freq;
        });

        for (int i = 0 ; i < chars.length(); i++) {
            pq.add(new GFG(chars.charAt(i),a[i],i));
        }

        while (pq.size() > 1) {
            GFG f = pq.poll();
            GFG s = pq.poll();
            GFG g = new GFG('$', f.freq + s.freq,-1);
            g.left = f;
            g.right = s;
            pq.add(g);
        }
        char[] code = new char[100];
        preOrder(pq.poll(),code,0);
        System.out.println();
    }

    private static void preOrder(GFG root, char[] code, int l) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            System.out.print(new String(code,0,l)+ " ");
        }
        code[l] = '0';
        preOrder(root.left, code,l+1);
        code[l] = '1';
        preOrder(root.right, code,l+1);
    }
}
