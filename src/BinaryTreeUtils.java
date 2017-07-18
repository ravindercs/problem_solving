package com.ood.di;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ravinderk on 6/11/2017.
 */
public class BinaryTreeUtils {
    static class Data {
        Node node;
        char tag;

        public Data(Node node, char tag) {
            this.node = node;
            this.tag = tag;
        }
    }

    public static void printLevelOrder(Node root) {
        if(root == null) return;
        Queue<Data> q = new LinkedList<>();
        q.add(new Data(root,'p'));

        while (!q.isEmpty()) {
            int count = q.size();
            while (count-- > 0) {
                Data n = q.remove();
                System.out.print(n.node.data+""+n.tag+" ");
                if(n.node.left != null) q.add(new Data(n.node.left,'l'));
                if(n.node.right != null) q.add(new Data(n.node.right,'r'));
            }
            System.out.println();
        }
    }

    public static void mirror(Node root) {
        if(root == null) return;
        mirror(root.left);
        mirror(root.right);
        Node t = root.left;
        t.left = t.right;
        t.right = t;
    }

    public static boolean isSameStruct(Node l, Node r) {
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;

        return isSameStruct(l.left,r.left) && isSameStruct(l.right, r.right);
    }
}
