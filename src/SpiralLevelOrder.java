package com.ood.di;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ravinderk on 6/12/2017.
 */
public class SpiralLevelOrder {
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(9);
        printSpiralLevelOrder(root);
    }

    /*
         1
       /   \
      2     3
     / \   / \
    4   5  6  7
    Queue :
    Stack :
    right = false;
    Console: 1 ,2, 3, 7,6,5,4
    1, 2, 3, 7, 6, 5, 4
     */
    public static void printSpiralLevelOrder(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Node> list = new LinkedList<>();
        boolean dirLeft = false;
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count-- > 0) {
                Node n = queue.remove();
                list.add(n);
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }

            while (!list.isEmpty()) {
                if(dirLeft) {
                    System.out.print(list.removeFirst().data+" ");
                } else {
                    System.out.print(list.removeLast().data+" ");
                }
            }
            dirLeft = !dirLeft;
            System.out.println();
        }
    }
}
