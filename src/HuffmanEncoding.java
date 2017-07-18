package com.ood.di;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ravinderk on 7/17/2017.
 */
public class HuffmanEncoding {
    static class DataNode {
        char ch;
        int freq;
        DataNode left,right;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-->0) {
            String str = s.next();
            List<DataNode> dataList = new ArrayList<>();
            for (int i = 0 ; i < str.length() ; i++) {
                DataNode d = new DataNode();
                d.ch = str.charAt(i);
                d.freq = s.nextInt();
                dataList.add(d);
            }

            printHuffmanCodes(dataList);
        }
    }

    private static void printHuffmanCodes(List<DataNode> dataList) {
        PriorityQueue<DataNode> pq = new PriorityQueue<>((f,s) -> f.freq - s.freq);
        for (int i = 0 ; i < dataList.size(); i++) {
            pq.add(dataList.get(i));
        }

        while (pq.size() > 1) {
            DataNode left = pq.poll();
            DataNode right = pq.poll();

            DataNode newNode = new DataNode();
            newNode.freq = left.freq + right.freq;
            newNode.ch = '$';
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        int[] code = new int[100];
        printCodes(pq.poll(),code,0);
        System.out.println();
    }

    private static void printCodes(DataNode root, int[] code, int level) {
        if(root == null) return;

        if(root.left != null) {
            code[level] = 0;
            printCodes(root.left,code,level+1);
        }
        if(root.right != null) {
            code[level] = 1;
            printCodes(root.right,code,level+1);
        }

        if(root.left == null && root.right == null) {
            System.out.print(root.ch+":");
            for (int i = 0 ; i < level ; i++) {
                System.out.print(code[i]);
            }
            System.out.print(" ");
        }
    }

    /*
    abcdef
5 9 13 13 13 45

Without common prefix....

f -> 0
e -> 10
d -> 11
c -> 101

      $(74)
    0/  \1
d(13)     $(61)
        0/ \1
     f(45)  e(16)
     */
}
