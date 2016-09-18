import java.util.*;

/**
 * Created by ravinderk on 7/20/2016.
 */
public class PrintBinaryTreeIn2D {
    public static void main(String[] args) {
        testSample();
        System.out.println("----------------------");
        testNull();
        System.out.println("----------------------");
        testOne();
        System.out.println("----------------------");
        testTwo();
        System.out.println("----------------------");
        testThree();
        System.out.println("----------------------");
        testFour();
        System.out.println("----------------------");
    }

    private static void print2D(TNode root) {
        print2D(root, 0);
    }

    private static void print2D(TNode root, int vD) {
        if(root == null) return;
        print2D(root.right, vD + 1);
        System.out.println();
        for (int i = 0 ; i < vD; i++) {
            System.out.print("    ");
        }
        System.out.println(root.i);
        print2D(root.left, vD + 1);
    }

    private static void testSample() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        root.right.left = new TNode(7);
        root.right.right = new TNode(31);
        root.left.right.left = new TNode(2);
        root.left.right.right = new TNode(4);
        print2D(root);
    }

    private static void testOne() {
        TNode root = new TNode(97);
        print2D(root);
    }

    private static void testNull() {
        print2D(null);
    }

    private static void testTwo() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        print2D(root);
    }

    private static void testThree() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        print2D(root);
    }

    private static void testFour() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        print2D(root);
    }
}
