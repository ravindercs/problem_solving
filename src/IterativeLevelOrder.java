package com.ood.di;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ravinderk on 6/11/2017.
 */
public class IterativeLevelOrder {
    static int maxWidth = -1;
    public static void main(String[] args) {
        int[] 	pre = new int[]{7,4,2,1,6,9,10,11};
        System.out.println("Height : "+ printBT(BTConstructor.constructBSTFromPreOrder(pre)));
        System.out.println("Max Width: "+maxWidth);
    }

    public static int printBT(Node root) {
        maxWidth = -1;
        if(root == null) return 0;

        int height = 0;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (true) {
            int levelNodeCount = q.size();
            if(levelNodeCount == 0) {
                return height;
            }
            height++;
            if(levelNodeCount > maxWidth) {
                maxWidth = levelNodeCount;
            }
            while (levelNodeCount > 0) {
                Node node = q.remove();
                System.out.print(node.data+" ");
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                levelNodeCount--;
            }
            System.out.println();
        }
    }
}
