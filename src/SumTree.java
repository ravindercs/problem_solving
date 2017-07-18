package com.ood.di;

/**
 * Created by ravinderk on 6/2/2017.
 */
public class SumTree {
    static class Node {
        Node left,right;
        int data;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        System.out.println(isSumTree(root));
    }

    private static boolean isSumTree(Node root) {
        int ls = 0,rs = 0;
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        if(isSumTree(root.left) && isSumTree(root.right)) {
            if(root.left == null) ls = 0;
            else if(root.left.left == null && root.left.right == null) ls = root.left.data;
            else ls = 2*root.left.data;

            if(root.right == null) rs = 0;
            else if(root.right.left == null && root.right.right == null) rs = root.right.data;
            else rs = 2*root.right.data;

            return root.data == (ls + rs);
        }

        return false;
    }
}