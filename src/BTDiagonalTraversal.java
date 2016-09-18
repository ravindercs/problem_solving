import java.util.*;

/**
 * Created by ravinderk on 7/20/2016.
 */
public class BTDiagonalTraversal {
    public static void main(String[] args) {
        System.out.println("------Sample-----");
        testSample();
        System.out.println("------Null-----");
        testNull();
        System.out.println("------One----");
        testOne();
        System.out.println("------Two----");
        testTwo();
        System.out.println("-----Three-----");
        testThree();
        System.out.println("------Four-----");
        testFour();
    }

    private static void getVerticalSumHM(TNode root) {
        if(root == null) return;
        HashMap<Integer, List<TNode>> hM = new HashMap<Integer, List<TNode>>();
        getVerticalSumHM(root, 0, hM);
        for (Integer i : hM.keySet()) {
            List<TNode> list = hM.get(i);
            for (TNode node : list) {
                System.out.print(node.i+" ");
            }
            System.out.println();
        }
    }

    private static void getVerticalSumHM(TNode root, int dD, HashMap<Integer, List<TNode>> hM) {
        if(root.left != null) {
            getVerticalSumHM(root.left, dD+1, hM);
        }
        List<TNode> list = hM.get(dD);
        if(list == null) {
            list = new LinkedList<TNode>();
            hM.put(dD, list);
        }
        list.add(root);
        if(root.right != null) {
            getVerticalSumHM(root.right, dD, hM);
        }
    }

    private static void testSample() {
        TNode root = new TNode(8);
        root.left = new TNode(3);
        root.right = new TNode(10);
        root.left.left = new TNode(1);
        root.left.right = new TNode(6);
        root.left.right.left = new TNode(4);
        root.left.right.right = new TNode(7);

        root.right.right = new TNode(14);
        root.right.right.left = new TNode(13);
        getVerticalSumHM(root);
    }

    private static void testOne() {
        TNode root = new TNode(97);
        getVerticalSumHM(root);
    }

    private static void testNull() {
        getVerticalSumHM(null);
    }

    private static void testTwo() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        getVerticalSumHM(root);
    }

    private static void testThree() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        getVerticalSumHM(root);
    }

    private static void testFour() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        getVerticalSumHM(root);
    }
}
