package com.ood.di;

import java.util.LinkedList;

/**
 * Created by ravinderk on 6/14/2017.
 */
/*
Given two BST, Your task is to complete the function merge which  prints the elements of both BSTs in sorted form.
 */
public class BSTMerger {
    public static void main(String[] args) {
        Node l = new Node(4);
        l.left = new Node(1);
        l.right = new Node(33);
        Node r = new Node(6);
        r.left = new Node(1);
        r.right = new Node(7);
        merge(l,r);
    }

    public static void merge(Node root1 , Node root2)
    {
        //In order traversal
        LinkedList<Node> l1 = new LinkedList<>();
        LinkedList<Node> l2 = new LinkedList<>();
        inOrder(root1, l1);
        inOrder(root2, l2);
        mergeList(l1,l2);
    }

    private static void mergeList(LinkedList<Node> l1, LinkedList<Node> l2) {
        while (!l1.isEmpty() && !l2.isEmpty()) {
            int d1 = l1.getFirst().data;
            int d2 = l2.getFirst().data;
            if(d1 == d2) {
                System.out.print(d1+" ");
                System.out.print(d2+" ");
                l1.remove();
                l2.remove();
            } else if (d1 < d2) {
                System.out.print(d1+" ");
                l1.remove();
            } else {
                System.out.print(d2+" ");
                l2.remove();
            }
        }

        while (!l1.isEmpty()) {
            System.out.print(l1.remove().data+" ");
        }

        while (!l2.isEmpty()) {
            System.out.print(l2.remove().data+" ");
        }
    }

    private static void inOrder(Node root, LinkedList<Node> list) {
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
