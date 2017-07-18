package com.ood.di;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ravinderk on 6/13/2017.
 */
public class ConnectNodesLevelOrder {
    static class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
    }

    public static void connect(Node root) {
        if(root == null) return ;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int levelNodeCount = q.size();
            Node prev = null;
            while (levelNodeCount > 0) {
                Node node = q.remove();
                System.out.print(node.data+" ");
                if(prev != null) {
                    prev.nextRight = node;
                }

                prev = node;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                levelNodeCount--;
            }

            if(prev != null) {
                prev.nextRight = null;
            }
        }
        System.out.println();
    }
}
