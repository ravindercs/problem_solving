import java.util.*;

/**
 * Created by ravinderk on 7/20/2016.
 */
public class LevelCornerBinaryTree {
    public static void main(String[] args) {
        testSample();
//        testNull();
//        testOne();
//        testTwo();
//        testThree();
//        testFour();
    }

    private static void printLevelCorner(TNode root) {
        if(root == null) return;
        Queue<TNode> first = new ArrayDeque<TNode>();
        Queue<TNode> second = new ArrayDeque<TNode>();
        first.add(root);
        while (!first.isEmpty()) {
            TNode f = first.remove();
            if (f.left != null) second.add(f.left);
            if (f.right != null) second.add(f.right);
            System.out.print(f.i + " ");
            TNode last = null;
            while (!first.isEmpty()) {
                last = first.remove();
                if (last.left != null) second.add(last.left);
                if (last.right != null) second.add(last.right);
            }
            if (last != null) {
                System.out.println(last.i + " ");
            }

            Queue<TNode> t = first;
            first = second;
            second = t;
        }
    }

    private static void testSample() {
        TNode root = new TNode(15);
        root.left = new TNode(10);
        root.right = new TNode(20);
        root.left.left = new TNode(8);
        root.left.right = new TNode(12);
        root.right.left = new TNode(16);
        root.right.right = new TNode(25);
        printLevelCorner(root);
    }

    private static void testOne() {
        TNode root = new TNode(97);
        printLevelCorner(root);
    }

    private static void testNull() {
        printLevelCorner(null);
    }

    private static void testTwo() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        printLevelCorner(root);
    }

    private static void testThree() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new  TNode(37);
        printLevelCorner(root);
    }

    private static void testFour() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        printLevelCorner(root);
    }

    static class TNode {
        int i;
        TNode left, right;

        public TNode(int i) {
            this.i = i;
            left = null;
            right = null;
        }
    }

    static class QData {
        TNode node;
        int vD;

        public QData(TNode node, int vD) {
            this.node = node;
            this.vD = vD;
        }
    }
}
