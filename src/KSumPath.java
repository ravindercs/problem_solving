package com.ood.di;

import java.util.Stack;

/**
 * Created by ravinderk on 6/20/2017.
 */
/*
A binary tree and a number k are given. Print the count of every path in
the tree with sum of the nodes in the path as k.
 */
public class KSumPath {
    public static void main(String[] args) {

    }

    public void printPaths(Node root)
    {
        Stack<Node> st = new Stack<>();
        printPaths(root,st);
    }

    private void printPaths(Node root, Stack<Node> st) {
        if(root == null) return;
        st.push(root);
        if(root.left == null && root.right == null) {
            st.forEach( n -> System.out.print(n.data));
            System.out.println();
        } else {
            printPaths(root.left,st);
            printPaths(root.right,st);
        }
        st.pop();
    }
}
